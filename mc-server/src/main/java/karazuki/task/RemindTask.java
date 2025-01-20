package karazuki.task;


import karazuki.mapper.ServantDetailMapper;
import karazuki.service.EmailService;
import karazuki.websocket.WebSocketServer;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@Component
public class RemindTask {

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ServantDetailMapper servantDetailMapper;

    //每日定时处理已撤回的消息
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteRecall(){
        emailService.delete();
    }


    //提醒每周任务更新
    @Scheduled(cron = "0 0 0 ? * * ")
    public void everyweekRemind(){
        webSocketServer.sendToAllUser("每周任务已更新");
        emailService.sendToAll("每周任务已更新");
    }

    //每月自动生成本月新增数据
    @Scheduled(cron = "0 0 0 1 * *")
    public void newData() throws IOException {
        //在内存中创建一个excel文件
        XSSFWorkbook excel = new XSSFWorkbook();

        //在Excel文件中创建一个Sheet页
        XSSFSheet sheet = excel.createSheet("info");


        LocalDate now = LocalDate.now();

        int year = now.getYear();
        Month month = now.getMonth();
        LocalDate begin = LocalDate.of(year, month, 1);
        LocalDate end = begin.with(TemporalAdjusters.lastDayOfMonth());

        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("本月新增从者数");  //createCell：创建单元格 setCellValue：在单元格中写入文本内容
        row.createCell(1).setCellValue("" + servantDetailMapper.getThisMonthNum(begin, end));
        //通过输出流将内存中的Excel文件写入到磁盘
        FileOutputStream out = new FileOutputStream(new File("D:\\info" + LocalDate.now() + ".xlsx")); //new FileOutputStream((D:\\info.xlsx));
        excel.write(out);

        out.close();
        excel.close();
    }
}

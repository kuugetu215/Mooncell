package karazuki.aspect;

import context.BaseContext;
import entity.ServantDetail;
import enumeration.OperationType;
import karazuki.annotation.AutoFill;
import karazuki.mapper.ServantDetailMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    @Autowired
    private ServantDetailMapper servantDetailMapper;

    /**
     * 切入点
     */
    @Pointcut("execution(* karazuki.mapper.*.*(..)) && @annotation(karazuki.annotation.AutoFill)")
    public void autoFullPointCut(){

    }

    @Pointcut("execution(* karazuki.mapper.*.*(..)) && @annotation(karazuki.annotation.FillTime)")
    public void fillTimePointCut(){}

    /**
     * 前置通知，在通知中进行公共字段通知
     * @param joinPoint
     */
    @Before("autoFullPointCut()")
    public void autoFill(JoinPoint joinPoint){
        log.info("开始进行公共字段的填充");
        //获取当前被拦截方法上的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();

        //获取到当前被拦截方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0){
            return;
        }

        Object entity = args[0];

        //准备赋值的数据

        LocalDateTime now = LocalDateTime.now();
        Integer currentId = BaseContext.getCurrentId();

        //根据当前不同的操作类型，为对应的属性通过反射来赋值
        if(operationType == OperationType.TIMEUSER){
            //为两个公共字段赋值
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod("setUpdateUser", Integer.class);

                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if(operationType == OperationType.TIME){
            //为一个公共字段赋值
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);

                //通过反射为对象赋值属性
                setUpdateTime.invoke(entity, now);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Before("fillTimePointCut()")
    public void FillTime(JoinPoint joinPoint){
        log.info("对其它表进行修改时更新servant_detail中的update_time和update_user");

        //获取到当前被拦截方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0){
            return;
        }

        String context = args[0].toString();
        int start = context.indexOf("sid");
        Integer sid = Integer.valueOf(context.substring(context.indexOf("=", start) + 1, context.indexOf(",", start)));

        ServantDetail servantDetail = new ServantDetail();
        LocalDateTime now = LocalDateTime.now();
        Integer id = BaseContext.getCurrentId();
        servantDetail.setUpdateTime(now);
        servantDetail.setUpdateUser(id);
        servantDetail.setSid(sid);

        servantDetailMapper.update(servantDetail);
    }
}

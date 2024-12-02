package karazuki.config;

import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import utils.AliOssUtil;

@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil() throws ClientException {
        log.info("开始创建阿里云文件上传工具类对象");
        return new AliOssUtil("oss-cn-wuhan-lr.aliyuncs.com",
                CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider(),
                "web-tlias-karazuki");
    }
}
package net.lainiao.dicom.scp;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "net.lainiao.dicom")
@MapperScan(basePackages = "net.lainiao.dicom.scp.dao")
@EnableCaching
public class PascScpStart {
    public static Logger logger = LoggerFactory.getLogger(PascScpStart.class);
    public static void main(String[] args) {
        logger.info("Dicom SCP Application Start!");
        SpringApplication.run(PascScpStart.class, args);
        logger.info("Dicom SCP Application Start Over!");
    }
}

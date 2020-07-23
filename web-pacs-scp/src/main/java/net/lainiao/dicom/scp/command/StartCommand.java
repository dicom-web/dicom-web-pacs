package net.lainiao.dicom.scp.command;

import net.lainiao.dicom.common.other.About;
import net.lainiao.dicom.scp.dicom.ScpModel;
import net.lainiao.dicom.scp.dicom.StoreSCP;
import net.lainiao.dicom.scp.service.ParseService;
import org.dcm4che3.net.TransferCapability;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class StartCommand implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(StartCommand.class);

    @Autowired
    About about;

    @Autowired
    ScpModel scpModel;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(String... strings) throws Exception {
        StoreSCP storeSCP=new StoreSCP();
        storeSCP.getAe().setAETitle(scpModel.getAeTitle());
        storeSCP.getConn().setPort(scpModel.getPort());
        storeSCP.getConn().setHostname("localhost");
        storeSCP.setStatus(0);
        storeSCP.setStatus(0);
        storeSCP.getAe().addTransferCapability(new TransferCapability(null,"*",TransferCapability.Role.SCP,"*"));
        File storageFile=new File(scpModel.getDicomDir());
        if(!storageFile.exists()){
            storageFile.mkdirs();
        }
        storeSCP.setStorageDirectory(storageFile);
        storeSCP.setStorageFilePathFormat("{0020000E}/{00080018}.dcm");
        ExecutorService executorService = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        storeSCP.getDevice().setScheduledExecutor(scheduledExecutorService);
        storeSCP.getDevice().setExecutor(executorService);
        storeSCP.getDevice().bindConnections();
        ParseService.start(applicationContext);
        logger.info("Dicom SCP Start Run For Version:"+about.getVersion());
    }
}

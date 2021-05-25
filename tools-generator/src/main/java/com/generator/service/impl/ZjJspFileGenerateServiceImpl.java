package com.generator.service.impl;

import com.generator.common.utils.GenerateUtils;
import com.generator.service.ZjJspFileGenerateService;
import com.generator.service.bo.ZjJspFileGenerateInBo;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ZjJspFileGenerateServiceImpl implements ZjJspFileGenerateService {
    @Override
    public String generatoJspFile(ZjJspFileGenerateInBo inBo) {
        // 模板文件的路径
        String tempFileUrl = inBo.getTempFilePath();
        File tempFile = new File(tempFileUrl);
        // 要生成的文件路径
        String fileUrl = inBo.getFilePath() + File.separator + inBo.getFileName() + ".jsp";
        File generatorFile = new File(fileUrl);

        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$titleName$", inBo.getPageName()) //文件名
                    .replace("$pageMark$", inBo.getPageMark())
                    .replace("$pageFileName$", inBo.getFileName());
            return tempStr;
        }, tempFile, generatorFile);
        return generateFilePath;
    }
}

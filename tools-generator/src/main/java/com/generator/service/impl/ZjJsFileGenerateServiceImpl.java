package com.generator.service.impl;

import com.generator.common.utils.GenerateUtils;
import com.generator.service.ZjJsFileGenerateService;
import com.generator.service.bo.ZjJsFileGenerateInBo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;

@Service
public class ZjJsFileGenerateServiceImpl implements ZjJsFileGenerateService {

    @Override
    public String generatoJsFile(ZjJsFileGenerateInBo inBo) {
        // 模板文件的路径
        String tempFileUrl = inBo.getTempFilePath();
        File tempFile = new File(tempFileUrl);
        // 要生成的文件路径
        String fileUrl = inBo.getFilePath() + File.separator + inBo.getFileName() + ".js";
        File generatorFile = new File(fileUrl);

        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$titleName$", inBo.getPageName()) //文件名
                    .replace("$pageMark$", inBo.getPageMark())
                    .replace("$searchConfigParams$", this.generatorQueryParamData(inBo))
                    .replace("$tableConfigParams$", this.generatorTableParamData(inBo))
                    .replace("$pageFileName$", inBo.getFileName());
            return tempStr;
        }, tempFile, generatorFile);
        return generateFilePath;
    }

    private CharSequence generatorTableParamData(ZjJsFileGenerateInBo inBo) {
        String tempFileParentPath = "";
        if(inBo.getTempFilePath().lastIndexOf("\\") != -1){
            tempFileParentPath = inBo.getTempFilePath().substring(0, inBo.getTempFilePath().lastIndexOf("\\")) + File.separator;
        }

        List<List<String>> tableParamList = inBo.getTableParamList();
        StringBuffer retultData = new StringBuffer();
        for (List<String> tableParam : tableParamList) {
            String tempFilePath = "";
            switch (tableParam.get(2)){
                case "form":
                    switch (tableParam.get(3)){
                        case "switch":
                            tempFilePath = tempFileParentPath + "ZjJsFileTemp_table_form_switch.txt";
                            break;
                        case "select":
                            tempFilePath = tempFileParentPath + "ZjJsFileTemp_table_form_select.txt";
                            break;
                    }
                    break;
                case "operation":
                    tempFilePath = tempFileParentPath + "ZjJsFileTemp_table_operation.txt";
                    break;
                default:
                    tempFilePath = tempFileParentPath + "ZjJsFileTemp_table_defaul.txt";
            }
            GenerateUtils.getTempFileContent((tempStr1) -> {
                retultData.append(tempStr1.replace("$lable$", tableParam.get(0))
                        .replace("$operationBtnInfo$", this.generatoroperationBtnInfo(inBo, tableParam.get(2)))
                        .replace("$ccsId$", tableParam.get(4))
                        .replace("$name$", tableParam.get(1)));
                return retultData.toString();
            }, new File(tempFilePath));
        }
        return retultData.toString();
    }

    private CharSequence generatoroperationBtnInfo(ZjJsFileGenerateInBo inBo, String type) {
        if(!"operation".equals(type)){
            return "";
        }
        List<List<String>> tableBtnParamList = inBo.getTableBtnParamList();
        if(CollectionUtils.isEmpty(tableBtnParamList)){
            return "";
        }
        String tempFileParentPath = "";
        if(inBo.getTempFilePath().lastIndexOf("\\") != -1){
            tempFileParentPath = inBo.getTempFilePath().substring(0, inBo.getTempFilePath().lastIndexOf("\\")) + File.separator;
        }
        StringBuffer retultData = new StringBuffer();
        for (List<String> queryParam : tableBtnParamList) {
            String tempFilePath = "";
            switch (queryParam.get(2)){
                case "skip":
                    tempFilePath = tempFileParentPath + "ZjJsFileTemp_table_operation_default.txt";
                    break;
                default:
                    tempFilePath = tempFileParentPath + "ZjJsFileTemp_table_operation_default.txt";
            }
            GenerateUtils.getTempFileContent((tempStr1) -> {
                retultData.append(tempStr1.replace("$buttonLable$", queryParam.get(0))
                        .replace("$buttonName$", queryParam.get(1))
                        .replace("$buttonUrl$", queryParam.get(3))
                        .replace("$windowName$", queryParam.get(4)));
                return retultData.toString();
            }, new File(tempFilePath));
        }
        return retultData.toString();
    }


    public String generatorQueryParamData(ZjJsFileGenerateInBo inBo) {
        List<List<String>> queryParamList = inBo.getQueryParamList();
        String tempFilePath = "ZjJsFileTemp_query.txt";
        if(inBo.getTempFilePath().lastIndexOf("\\") != -1){
            tempFilePath = inBo.getTempFilePath().substring(0, inBo.getTempFilePath().lastIndexOf("\\")) + File.separator + tempFilePath;
        }
        //字段信息
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成字段信息
            for (List<String> queryParam : queryParamList) {
                stringBuffer.append(tempStr1.replace("$lable$", queryParam.get(0))
                        .replace("$name$", queryParam.get(1))
                        .replace("$type$", queryParam.get(2))
                        .replace("$span$", queryParam.get(3)));
            }
            return stringBuffer.toString();
        },new File(tempFilePath));
    }

}

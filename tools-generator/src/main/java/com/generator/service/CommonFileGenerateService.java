package com.generator.service;

import com.generator.service.bo.CommonFileGenerateInBo;

import java.io.IOException;

public interface CommonFileGenerateService {
    /**
     * 生成Dos impl文件
     * @param inBo
     * @return
     */
    String generatoDosImplFile(CommonFileGenerateInBo inBo);

    /**
     * 生成Dos 接口文件
     * @param inBo
     * @return
     */
    String generatoDosInfFile(CommonFileGenerateInBo inBo);

    /**
     * 生成Dos xml文件
     * @param inBo
     * @return
     */
    String generatoDosXmlFile(CommonFileGenerateInBo inBo) throws IOException;

    /**
     * 生成Inbo.java文件
     * @param inBo
     * @return
     */
    String generatoInBoFile(CommonFileGenerateInBo inBo);

    /**
     * 生成Dos xml文件
     * @param inBo
     * @return
     */
    String generatoDosTestFile(CommonFileGenerateInBo inBo);

    /**
     * 生成Outbo.java文件
     * @param inBo
     * @return
     */
    String generatoOutBoFile(CommonFileGenerateInBo inBo);
}

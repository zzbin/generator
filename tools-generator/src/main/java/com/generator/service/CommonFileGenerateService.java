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
     * 生成Inbo文件
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
     * 生成Outbo 文件
     * @param inBo
     * @return
     */
    String generatoOutBoFile(CommonFileGenerateInBo inBo);
    /**
     * 生成InVo文件
     * @param inBo
     * @return
     */
    String generatoInVoFile(CommonFileGenerateInBo inBo);
    /**
     * 生成OutVo文件
     * @param inBo
     * @return
     */
    String generatoOutVoFile(CommonFileGenerateInBo inBo);
    /**
     * 生成service 接口文件
     * @param inBo
     * @return
     */
    String generatoServiceInfFile(CommonFileGenerateInBo inBo);
    /**
     * 生成service impl文件
     * @param inBo
     * @return
     */
    String generatoServiceImplFile(CommonFileGenerateInBo inBo);
    /**
     * 生成service test文件
     * @param inBo
     * @return
     */
    String generatoServiceTestFile(CommonFileGenerateInBo inBo);
    /**
     * 生成bs 接口文件
     * @param inBo
     * @return
     */
    String generatoBsInfFile(CommonFileGenerateInBo inBo);
    /**
     * 生成bs impl文件
     * @param inBo
     * @return
     */
    String generatoBsImplFile(CommonFileGenerateInBo inBo);
}

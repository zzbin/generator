package com.generator.service;

import com.generator.service.bo.ZjJsFileGenerateInBo;

public interface ZjJsFileGenerateService {

    /**
     * 生成jsp文件
     * @param inBo
     * @return
     */
    String generatoJsFile(ZjJsFileGenerateInBo inBo);

}

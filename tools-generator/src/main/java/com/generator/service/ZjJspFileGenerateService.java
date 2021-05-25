package com.generator.service;

import com.generator.service.bo.ZjJspFileGenerateInBo;

public interface ZjJspFileGenerateService {

    /**
     * 生成jsp文件
     * @param inBo
     * @return
     */
    String generatoJspFile(ZjJspFileGenerateInBo inBo);

}

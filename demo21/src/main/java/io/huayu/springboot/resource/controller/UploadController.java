/*
 * Copyright Huayu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.huayu.springboot.resource.controller;

import io.huayu.springboot.framework.common.api.ApiResult;
import io.huayu.springboot.framework.core.properties.SpringBootPlusProperties;
import io.huayu.springboot.framework.util.UploadUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 上传控制器
 * @author weiqian
 * @date 2019/8/20
 * @since 1.2.1-RELEASE
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private SpringBootPlusProperties springBootPlusProperties;

    /**
     * 上传单个文件
     */
    @PostMapping("/file")
    @ApiOperation(value = "上传单个文件",notes = "上传单个文件",response = ApiResult.class)
    public ApiResult<Boolean> upload(@RequestParam("file") MultipartFile multipartFile,
                                     @RequestParam("type") String type) throws Exception{
        log.info("multipartFile = " + multipartFile);
        log.info("ContentType = " + multipartFile.getContentType());
        log.info("OriginalFilename = " + multipartFile.getOriginalFilename());
        log.info("Name = " + multipartFile.getName());
        log.info("Size = " + multipartFile.getSize());
        log.info("type = " + type);

        // 上传文件，返回保存的文件名称
        String saveFileName = UploadUtil.upload(springBootPlusProperties.getUploadPath(), multipartFile, originalFilename -> {
            // 文件后缀
            String fileExtension= FilenameUtils.getExtension(originalFilename);
            // 这里可自定义文件名称，比如按照业务类型/文件格式/日期
            String dateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssS"));
            String fileName = dateString + "." +fileExtension;
            return fileName;
        });

        // 上传成功之后，返回访问路径，请根据实际情况设置

        String fileAccessPath = springBootPlusProperties.getResourceAccessUrl() + saveFileName;
        log.info("fileAccessPath:{}",fileAccessPath);

        return ApiResult.ok(fileAccessPath);
    }


    @PostMapping("/images")
    @ApiOperation(value = "上传图片",notes = "上传图片",response = ApiResult.class)
    public ApiResult<Boolean> images(@RequestParam("file") MultipartFile[] multipartFile,
                                     @RequestParam("type") String type) throws Exception {

        log.info(multipartFile.toString());




        String[] arrFiles = new String[multipartFile.length];
        //这里可以支持多文件上传
        if (multipartFile != null && multipartFile.length >= 1) {
            Integer i = 0;
            for (MultipartFile file : multipartFile) {

                log.info("multipartFile = " + multipartFile[i]);
                log.info("ContentType = " + multipartFile[i].getContentType());
                log.info("OriginalFilename = " + multipartFile[i].getOriginalFilename());
                log.info("Name = " + multipartFile[i].getName());
                log.info("Size = " + multipartFile[i].getSize());
                log.info("type = " + type);


                // 上传文件，返回保存的文件名称
                String saveFileName = UploadUtil.upload(springBootPlusProperties.getUploadPath(), multipartFile[i], originalFilename -> {
                    // 文件后缀
                    String fileExtension= FilenameUtils.getExtension(originalFilename);
                    // 这里可自定义文件名称，比如按照业务类型/文件格式/日期
                    String dateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssS"));
                    String fileName = dateString + "." +fileExtension;
                    return fileName;
                });
                arrFiles[i] = saveFileName;
                i++;
            }

        }
        return ApiResult.ok(arrFiles);
    }


}

package com.purcotton.omni.promotion.rule.service;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

@Service
@Slf4j
public class RuleTableService {
    /**
     * 默认规则文件所在路径
     */
    private static final String RULES_PATH = "rules/tables";

    public String getRuleTable() {
        //把excel翻译成drl文件
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String rules = compiler.compile(ResourceFactory.newClassPathResource(RULES_PATH + File.separator + "rule.xlsx", "UTF-8"), "rule-table");
        System.out.println(rules);
        return rules;
    }

    /**
     * 通过决策表文件流获取rule
     *
     * @param inputStream 决策表文件流
     * @return rule
     */
    public String getRuleTable(InputStream inputStream) {
        //把excel翻译成drl文件
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String rules = compiler.compile(ResourceFactory.newInputStreamResource(inputStream, "UTF-8"), "rule-table");
        log.info("get rule from xls:" + rules);
        return rules;
    }

    public boolean checkFlag(){
        return true;
    }



}

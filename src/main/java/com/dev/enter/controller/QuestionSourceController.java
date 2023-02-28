package com.dev.enter.controller;

import com.dev.enter.mapper.QuestionSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@RestController
@RequestMapping("/question-source-entity")
public class QuestionSourceController {
       @Autowired
        QuestionSourceMapper questionSourceMapper;

}

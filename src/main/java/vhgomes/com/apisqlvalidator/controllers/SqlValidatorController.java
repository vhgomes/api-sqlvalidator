package vhgomes.com.apisqlvalidator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vhgomes.com.apisqlvalidator.service.SqlValidatorService;

@Controller("/api")
public class SqlValidatorController {

    private final SqlValidatorService sqlValidatorService;

    public SqlValidatorController(SqlValidatorService sqlValidatorService) {
        this.sqlValidatorService = sqlValidatorService;
    }

    @GetMapping("/validate-sql")
    public ResponseEntity<?> validateSql(@RequestParam String sql) {
        return sqlValidatorService.validate(sql);
    }
}

package vhgomes.com.apisqlvalidator.service;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statements;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vhgomes.com.apisqlvalidator.dtos.ResponseCorrectSQLDTO;
import vhgomes.com.apisqlvalidator.dtos.ResponseIncorrectSQLDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SqlValidatorService {

    public ResponseEntity<?> validate(String sql) {
        try {
            Statements statements = CCJSqlParserUtil.parseStatements(sql);
            ResponseCorrectSQLDTO response = new ResponseCorrectSQLDTO("SQL is correct", statements.toString());
            return ResponseEntity.ok(response);
        } catch (JSQLParserException e) {
            List<String> causes = getAllCausesMessages(e);
            ResponseIncorrectSQLDTO response = new ResponseIncorrectSQLDTO("SQL is incorrect", causes);
            return ResponseEntity.ok().body(response);
        }
    }

    public List<String> getAllCausesMessages(Throwable throwable) {
        List<String> causes = new ArrayList<>();
        while (throwable != null) {
            String message = throwable.getMessage();
            String messageTreated = errorTreatment(message);
            if (message != null && !message.isEmpty()) {
                causes.add(messageTreated);
            }
            throwable = throwable.getCause();
        }
        causes = removeDuplicates(causes);
        return causes;
    }

    public String errorTreatment(String error) {
        // String regex = "\\n|<EOF>|\\s{2,}|\"|\\\\";
        String regex = "\\n|<EOF>|\\s{2,}|\\\\";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(error);
        return matcher.replaceAll("");
    }

    public static List<String> removeDuplicates(List<String> causes) {
        Set<String> set = new HashSet<>(causes);
        return new ArrayList<>(set);
    }
}


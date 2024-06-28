package vhgomes.com.apisqlvalidator.dtos;

import java.util.List;

public record ResponseIncorrectSQLDTO(String message, List<String> causes) {
}

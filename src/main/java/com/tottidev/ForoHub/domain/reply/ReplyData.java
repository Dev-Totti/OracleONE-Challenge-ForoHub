package com.tottidev.ForoHub.domain.reply;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ReplyData(
        @NotBlank
        String message,

        @NotNull
        Long topic,

        @NotNull
        Long author

) {
}

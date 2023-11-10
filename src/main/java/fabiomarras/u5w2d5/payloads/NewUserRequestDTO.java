package fabiomarras.u5w2d5.payloads;

import jakarta.validation.constraints.NotNull;

public record NewUserRequestDTO() {
    @NotNull(message = "campo obbligatorio")
}

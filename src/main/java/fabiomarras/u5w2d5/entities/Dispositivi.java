package fabiomarras.u5w2d5.entities;

import fabiomarras.u5w2d5.Enum.StatusDispositivi;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Dispositivi {
    @Id
    @GeneratedValue
    private int id;
    private String type;
    @Enumerated
    private StatusDispositivi statusDispositivi;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;
}

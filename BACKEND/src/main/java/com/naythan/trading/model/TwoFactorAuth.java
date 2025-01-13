package com.naythan.trading.model;


import com.naythan.trading.domain.verificationType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Embeddable
public class TwoFactorAuth {
    private boolean isEnabled =false;

    @Enumerated(EnumType.STRING)
    private verificationType  sendTo;

}

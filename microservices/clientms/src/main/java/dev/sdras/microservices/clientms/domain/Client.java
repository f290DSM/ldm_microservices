package dev.sdras.microservices.clientms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private String uuid;
    private String name;
    private String email;
    private String address;
}

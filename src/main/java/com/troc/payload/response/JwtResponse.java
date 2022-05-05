package com.troc.payload.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private int expirationTime;
  private String username;
  private String email;
  private List<String> roles;
}

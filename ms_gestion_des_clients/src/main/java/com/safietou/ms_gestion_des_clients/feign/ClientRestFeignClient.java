package com.safietou.ms_gestion_des_clients.feign;

import com.safietou.ms_gestion_des_clients.beans.ClientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="GESTION-DES-UTILISATEURS")
public interface ClientRestFeignClient {

    @GetMapping("/clients/{id}")
    ClientBean getClient(@PathVariable("id") Long id);
}

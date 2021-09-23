package com.safietou.ms_gestion_des_clients.feign;

import com.safietou.ms_gestion_des_clients.beans.BienImmobiliereBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="GESTION-BIENS-ET-PROJET")
public interface BienImmobiliereRestClient {

    @GetMapping("/biens/{id}")
    BienImmobiliereBean getById(@PathVariable("id") Long id);
}

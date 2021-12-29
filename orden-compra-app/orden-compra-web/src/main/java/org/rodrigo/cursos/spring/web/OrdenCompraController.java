/**
 * OrdenCompraController.java
 * Creation Date: Nov 11, 2020, 8:38:10 PM
 *
 * Copyright (C) 2019,2020 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package org.rodrigo.cursos.spring.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rodrigo.cursos.spring.core.domain.ArticuloOrden;
import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;
import org.rodrigo.cursos.spring.core.service.OrdenCompraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO [Add class documentation]
 */

@Controller
@RequestMapping("/ordenes/")
public class OrdenCompraController {

  private static final Logger logger = LogManager.getLogger();

  @Resource
  private OrdenCompraService ordenCompraService;

  /**
   * Este método se invoca cuando el usuario desea visualizar el formulario para
   * capturar un orden de compra-
   * @return
   */
  @RequestMapping("capturaOrdenCompra")
  public String captura(ModelMap model) {
    OrdenCompra orden;

    orden = new OrdenCompra();
    orden.setStatus(StatusOrden.REGISTRADA);
    orden.setFechaStatus(new Date());
    model.addAttribute(orden);

    logger.debug("Incializando pantalla de captura {}", orden);

    return "capturaOrdenCompra";
  }

  @RequestMapping("crearOrdenCompra")
  public String crearOrdenCompra(@Valid OrdenCompra orden, BindingResult result,
    ModelMap model) {

    if (result.hasErrors()) {
      return "capturaOrdenCompra";
    }

    orden.setArticulos(List.of(new ArticuloOrden()));

    logger.debug("Registrando orden de compra en BD {}", orden);
    ordenCompraService.registraOrden(orden);

    model.addAttribute(orden);

    return "confirmaOrdenCompra";
  }
}

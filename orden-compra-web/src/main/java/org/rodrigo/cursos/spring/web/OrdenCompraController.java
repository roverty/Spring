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

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO [Add class documentation]
 */

@Controller
public class OrdenCompraController {

  @Resource
  private OrdenCompraService ordenCompraService;

  public String capturaOrdenCompra() {
    return "capturaOrdenCompra";
  }

  @RequestMapping("crearOrdenCompra")
  public String crearOrdenCompra(OrdenCompra orden) {
    return "confirmaCrearOrden";
  }
}

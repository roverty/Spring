/**
 * OrdenCompraValidator.java
 * Creation Date: Dec 2, 2020, 7:56:13 PM
 *
 * Copyright (C) 2019,2020 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package org.rodrigo.cursos.spring.web.validators;

import java.util.Date;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * TODO [Add class documentation]
 */

public class OrdenCompraValidator implements Validator {

  /*
   * See the original documentation of the method declaration
   * @see org.springframework.validation.Validator#supports(java.lang.Class)
   */
  @Override
  public boolean supports(Class<?> clazz) {

    return OrdenCompra.class.equals(clazz);
  }

  /*
   * See the original documentation of the method declaration
   * @see org.springframework.validation.Validator#validate(java.lang.Object,
   * org.springframework.validation.Errors)
   */
  @Override
  public void validate(Object target, Errors errors) {

    OrdenCompra orden = (OrdenCompra) target;

    ValidationUtils.rejectIfEmpty(errors, "fechaCompra", "required");
    ValidationUtils.rejectIfEmpty(errors, "fechaStatus", "required");

    if (orden.getFechaCompra() == null
      && orden.getFechaCompra().compareTo(new Date()) > 0) {
      errors.reject("fechaCompra", "invalid.date");
    }

  }

}

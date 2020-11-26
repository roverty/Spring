/**
 * CustomBindingInitializer.java
 * Creation Date: Nov 18, 2020, 7:31:51 PM
 *
 * Copyright (C) 2019,2020 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package org.rodrigo.cursos.spring.web.binding;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

/**
 * TODO [Add class documentation]
 */

public class CustomBindingInitializer implements WebBindingInitializer {

  public static final String DATE_FORMAT = "dd/mm/yyyy";

  private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

  /*
   * See the original documentation of the method declaration
   * @see org.springframework.web.bind.support.WebBindingInitializer#initBinder(org.
   * springframework.web.bind.WebDataBinder) yyyy-mm-dd -> dd-mm-yyyy
   */
  @Override
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }

}

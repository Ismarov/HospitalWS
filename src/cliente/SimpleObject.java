/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package cliente;

import java.util.LinkedHashMap;

/**
 * Este es el mapa retornado para todos los objetos, las propiedades son pares
 * clave/valor. Si un objeto tiene subobjetos, entonces estos son listas de
 * SimpleObjects.
 */
public class SimpleObject extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public SimpleObject() {
		super();
	}

	/**
	 * Le da propiedades a este mapa, y retorna el mism mapa (para llamadas
	 * anidadas)
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SimpleObject add(String key, Object value) {
		put(key, value);
		return this;
	}

}
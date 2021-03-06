/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2012 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.api.component.mock;

import org.sonar.api.component.SourceFile;

public class MockSourceFile implements SourceFile {
  private String key;
  private String qualifier;
  private String language;
  private String name;
  private String longName;

  private MockSourceFile() {
  }

  public String key() {
    return key;
  }

  public MockSourceFile setKey(String key) {
    this.key = key;
    return this;
  }

  public String qualifier() {
    return qualifier;
  }

  public MockSourceFile setQualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  public String language() {
    return language;
  }

  public MockSourceFile setLanguage(String language) {
    this.language = language;
    return this;
  }

  public String name() {
    return name;
  }

  public MockSourceFile setName(String name) {
    this.name = name;
    return this;
  }

  public String longName() {
    return longName;
  }

  public MockSourceFile setLongName(String longName) {
    this.longName = longName;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MockSourceFile that = (MockSourceFile) o;
    return !(key != null ? !key.equals(that.key) : that.key != null);
  }

  @Override
  public int hashCode() {
    return key != null ? key.hashCode() : 0;
  }

  public static MockSourceFile createMain(String key) {
    return new MockSourceFile().setKey(key).setQualifier("FIL");
  }
}

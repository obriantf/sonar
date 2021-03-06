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
package org.sonar.jpa.session;

import org.sonar.core.persistence.Database;
import org.sonar.core.persistence.DatabaseVersion;
import org.sonar.jpa.entity.SchemaMigration;

import javax.persistence.EntityManager;

public class MemoryDatabaseConnector extends DefaultDatabaseConnector {
  private int version;

  public MemoryDatabaseConnector(Database database) {
    super(database);
    version = DatabaseVersion.LAST_VERSION;
  }

  @Override
  public void start() {
    super.start();
    setupSchemaVersion(version);
  }

  protected void setupSchemaVersion(int version) {
    SchemaMigration migration = new SchemaMigration();
    migration.setVersion(version);
    EntityManager manager = createEntityManager();
    try {
      manager.getTransaction().begin();
      manager.persist(migration);
      manager.getTransaction().commit();

    } finally {
      if (manager != null) {
        manager.close();
      }
    }
  }
}
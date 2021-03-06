/*
 * JBoss, Home of Professional Open Source
 * Copyright 2007, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 *
 * (C) 2005-2006,
 * @author JBoss Inc.
 */
//
// Copyright (C) 1998, 1999, 2000, 2001, 2002, 2003
//
// Arjuna Technologies Ltd.,
// Newcastle upon Tyne,
// Tyne and Wear,
// UK.
//

package org.jboss.jbossts.qa.CrashRecovery05Clients1;

/*
 * Copyright (C) 1999-2001 by HP Bluestone Software, Inc. All rights Reserved.
 *
 * HP Arjuna Labs,
 * Newcastle upon Tyne,
 * Tyne and Wear,
 * UK.
 *
 * $Id: Client03b.java,v 1.2 2003/06/26 11:43:30 rbegg Exp $
 */

/*
 * Try to get around the differences between Ansi CPP and
 * K&R cpp with concatenation.
 */

/*
 * Copyright (C) 1999-2001 by HP Bluestone Software, Inc. All rights Reserved.
 *
 * HP Arjuna Labs,
 * Newcastle upon Tyne,
 * Tyne and Wear,
 * UK.
 *
 * $Id: Client03b.java,v 1.2 2003/06/26 11:43:30 rbegg Exp $
 */


import org.jboss.jbossts.qa.CrashRecovery05.CrashBehavior;
import org.jboss.jbossts.qa.Utils.OTS;

public class Client03b
{
	public static void main(String[] args)
    {
        ClientBeforeCrash beforeCrash = new ClientBeforeCrash(Client01b.class.getSimpleName());

		try
		{
            beforeCrash.initOrb(args);
            beforeCrash.initCrashBehaviour(CrashBehavior.CrashBehaviorCrashInRollback);
            beforeCrash.serviceSetup();

			OTS.current().rollback();

            beforeCrash.reportStatus();
		}
		catch (Exception exception)
		{
			beforeCrash.reportException(exception);
		}
        finally {
            beforeCrash.shutdownOrb();
        }
	}
}

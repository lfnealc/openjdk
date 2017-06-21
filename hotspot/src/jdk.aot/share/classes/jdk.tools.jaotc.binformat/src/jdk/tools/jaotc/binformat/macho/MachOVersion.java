/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package jdk.tools.jaotc.binformat.macho;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import jdk.tools.jaotc.binformat.macho.MachO;
import jdk.tools.jaotc.binformat.macho.MachO.version_min_command;
import jdk.tools.jaotc.binformat.macho.MachOByteBuffer;

public class MachOVersion {
    ByteBuffer version;

    public MachOVersion() {
        version = MachOByteBuffer.allocate(version_min_command.totalsize);

        version.putInt(version_min_command.cmd.off, version_min_command.LC_VERSION_MIN_MACOSX);
        version.putInt(version_min_command.cmdsize.off, version_min_command.totalsize);
        version.putInt(version_min_command.version.off, (10 << 16) | (10 << 8)); /* MacOSX 10.10 */
        version.putInt(version_min_command.sdk.off, 0); /* N/A SDK */
    }

    public byte[] getArray() {
        return version.array();
    }
}


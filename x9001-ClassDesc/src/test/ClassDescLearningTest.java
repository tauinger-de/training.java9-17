package test;

import org.junit.jupiter.api.Test;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;

import static org.junit.jupiter.api.Assertions.*;

public class ClassDescLearningTest {

    @Test
    public void testClassDescOf() {
        final ClassDesc cd1 = ClassDesc.of("appl.Foo");
        final ClassDesc cd2 = ClassDesc.of("appl", "Foo");
        final ClassDesc cd3 = ClassDesc.of("appl.Foo");
        assertEquals(cd1, cd2);
        assertEquals(cd1, cd3);
        assertNotSame(cd1, cd2);
        assertNotSame(cd1, cd3);
    }

    @Test
    public void testPrimitive() {
        final ClassDesc cd = ClassDesc.ofDescriptor("I");
        final ClassDesc cd2 = ConstantDescs.CD_int;
        assertEquals(cd, cd2);

        assertEquals("PrimitiveClassDesc[int]", cd.toString());
        assertEquals("I", cd.descriptorString());
        assertEquals("int", cd.displayName());
        assertEquals("", cd.packageName());
        assertTrue(cd.isPrimitive());
        assertFalse(cd.isClassOrInterface());
        assertFalse(cd.isArray());
    }

    @Test
    public void testPrimitiveArray() {
        final ClassDesc cd = ClassDesc.ofDescriptor("I").arrayType();
        assertEquals("ClassDesc[int[]]", cd.toString());
        assertEquals("[I", cd.descriptorString());
        assertEquals("int[]", cd.displayName());
        assertEquals("", cd.packageName());
        assertFalse(cd.isPrimitive());
        assertFalse(cd.isClassOrInterface());
        assertTrue(cd.isArray());
        assertEquals(ClassDesc.ofDescriptor("I"), cd.componentType());
    }

    @Test
    public void testClass() {
        final ClassDesc cd = ClassDesc.of("appl.Foo");
        assertEquals("ClassDesc[Foo]", cd.toString());
        assertEquals("Lappl/Foo;", cd.descriptorString());
        assertEquals("Foo", cd.displayName());
        assertEquals("appl", cd.packageName());
        assertFalse(cd.isPrimitive());
        assertTrue(cd.isClassOrInterface());
        assertFalse(cd.isArray());
    }

    @Test
    public void testClassArray() {
        final ClassDesc cd = ClassDesc.of("appl", "Foo").arrayType();
        assertEquals("ClassDesc[Foo[]]", cd.toString());
        assertEquals("[Lappl/Foo;", cd.descriptorString());
        assertEquals("Foo[]", cd.displayName());
        assertEquals("", cd.packageName());
        assertFalse(cd.isPrimitive());
        assertFalse(cd.isClassOrInterface());
        assertTrue(cd.isArray());
        assertEquals(ClassDesc.of("appl", "Foo"), cd.componentType());
    }
}

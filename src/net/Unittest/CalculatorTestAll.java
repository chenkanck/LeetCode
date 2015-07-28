package net.Unittest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CalculatorTest.class,
	CalculatorTestSquare.class
})
public class CalculatorTestAll {


}

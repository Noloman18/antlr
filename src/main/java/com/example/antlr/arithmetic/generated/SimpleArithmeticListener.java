package com.example.antlr.arithmetic.generated;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleArithmeticParser}.
 */
public interface SimpleArithmeticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleArithmeticParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleArithmeticParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleArithmeticParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleArithmeticParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(SimpleArithmeticParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleArithmeticParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(SimpleArithmeticParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleArithmeticParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(SimpleArithmeticParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleArithmeticParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(SimpleArithmeticParser.FactorContext ctx);
}
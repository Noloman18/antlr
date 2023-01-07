package com.example.antlr.arithmetic;

import com.example.antlr.arithmetic.generated.SimpleArithmeticBaseVisitor;
import com.example.antlr.arithmetic.generated.SimpleArithmeticLexer;
import com.example.antlr.arithmetic.generated.SimpleArithmeticParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

public interface ArithmeticService {
    Double calculateExpression(String expression);
}

@Service
class ArithmeticServiceImpl implements ArithmeticService {

    @Override
    public Double calculateExpression(String expression) {
        try {

            var lexer = new SimpleArithmeticLexer(CharStreams.fromString((expression)));
            SimpleArithmeticParser parser =
                    new SimpleArithmeticParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.expression();

            EvalVisitor visitor = new EvalVisitor();
            return visitor.visit(tree);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class EvalVisitor extends SimpleArithmeticBaseVisitor<Double> {
    @Override
    public Double visitExpression(SimpleArithmeticParser.ExpressionContext ctx) {
        double result = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            if (ctx.PLUS(i - 1) != null) {
                result += visit(ctx.term(i));
            } else {
                result -= visit(ctx.term(i));
            }
        }
        return result;
    }

    @Override
    public Double visitTerm(SimpleArithmeticParser.TermContext ctx) {
        double result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            if (ctx.MULT(i - 1) != null) {
                result *= visit(ctx.factor(i));
            }
            else if (ctx.POW(i - 1) != null) {
                result = Math.pow(result,visit(ctx.factor(i)));
            }else {
                result /= visit(ctx.factor(i));
            }
        }
        return result;
    }

    @Override
    public Double visitFactor(SimpleArithmeticParser.FactorContext ctx) {
        if (ctx.NUMBER() != null) {
            return Double.valueOf(ctx.NUMBER().getText());
        }

        return visit(ctx.expression());
    }
}


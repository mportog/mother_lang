// Generated from /Users/matheusporto/Documents/mother_lang/motherLang/MotherLang.g4 by ANTLR 4.7.1
package br.com.ufabc.motherLanguage.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MotherLangParser}.
 */
public interface MotherLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MotherLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MotherLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MotherLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MotherLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(MotherLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(MotherLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(MotherLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(MotherLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(MotherLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(MotherLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(MotherLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(MotherLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(MotherLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(MotherLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(MotherLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(MotherLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(MotherLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(MotherLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(MotherLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(MotherLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MotherLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MotherLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MotherLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(MotherLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MotherLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(MotherLangParser.TermoContext ctx);
}
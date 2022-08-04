// Generated from /Users/matheusporto/Documents/mother_lang/motherLang/MotherLang.g4 by ANTLR 4.10.1
package br.com.ufabc.motherLanguage.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MotherLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MotherLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MotherLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(MotherLangParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#declaravar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaravar(MotherLangParser.DeclaravarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(MotherLangParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(MotherLangParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(MotherLangParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdleitura(MotherLangParser.CmdleituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdescrita(MotherLangParser.CmdescritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdattrib(MotherLangParser.CmdattribContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdselecao(MotherLangParser.CmdselecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MotherLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MotherLangParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(MotherLangParser.TermoContext ctx);
}
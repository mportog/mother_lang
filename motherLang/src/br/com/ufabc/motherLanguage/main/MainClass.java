package br.com.ufabc.motherLanguage.main;

import br.com.ufabc.motherLanguage.exception.MotherLanguageException;
import br.com.ufabc.motherLanguage.parser.MotherLangLexer;
import br.com.ufabc.motherLanguage.parser.MotherLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class MainClass {
    public static void main(String[] args) {
        try {
            MotherLangLexer lexer = new MotherLangLexer(CharStreams.fromFileName("input.mother"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            MotherLangParser parser = new MotherLangParser(tokenStream);

            parser.prog();
            parser.exibeComandos();
            parser.generateCode();

            System.out.println("Compilation Successful");

        } catch (MotherLanguageException exception) {
            System.out.println("Semantic Error: " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
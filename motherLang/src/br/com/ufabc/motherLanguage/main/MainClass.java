package br.com.ufabc.motherLanguage.main;

import br.com.ufabc.motherLanguage.exception.MotherSemanticException;
import br.com.ufabc.motherLanguage.parser.MotherLangLexer;
import br.com.ufabc.motherLanguage.parser.MotherLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import static br.com.ufabc.motherLanguage.main.MainClass.MotherLangInputSource.*;

public class MainClass {
    enum MotherLangInputSource {
        INPUT_ENTREGA("input.mother"),
        INPUT_TESTANDO_ERROS("input_teste_erros.mother"),
        INPUT_SELECIONA_CASO("input_seleciona_caso.mother"),
        INPUT_ENQAUNTO("input_enquanto.mother");

        public final String ambiente;

        MotherLangInputSource(String ambiente) {
            this.ambiente = ambiente;
        }
    }

    public static void main(String[] args) {
        try {
            MotherLangLexer lexer = new MotherLangLexer(CharStreams.fromFileName("input.mother"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            MotherLangParser parser = new MotherLangParser(tokenStream);

            parser.prog();
            parser.exibeComandos();

            parser.generateJavaCode();
            parser.generatePhytonCode();

            System.out.println("Compilation Successful");

        } catch (MotherSemanticException exception) {
            System.out.println("MOTHERLANG SEMANTIC ERROR: " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("GENERIC ERROR: " + exception.getMessage());
        }
    }
}
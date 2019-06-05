package mic.model_code_synchronization.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import mic.model_code_synchronization.services.MappingDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMappingDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'class'", "'method'", "'IM'", "'{'", "'}'", "'codestructure'", "':'", "'modelelement'", "'condition'", "'mapping'", "'Mapping'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMappingDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMappingDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMappingDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMappingDSL.g"; }


    	private MappingDSLGrammarAccess grammarAccess;

    	public void setGrammarAccess(MappingDSLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalMappingDSL.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalMappingDSL.g:54:1: ( ruleModel EOF )
            // InternalMappingDSL.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMappingDSL.g:62:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:66:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalMappingDSL.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalMappingDSL.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalMappingDSL.g:68:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalMappingDSL.g:69:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||(LA1_0>=18 && LA1_0<=21)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMappingDSL.g:69:4: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalMappingDSL.g:78:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalMappingDSL.g:79:1: ( ruleAbstractElement EOF )
            // InternalMappingDSL.g:80:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalMappingDSL.g:87:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:91:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalMappingDSL.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalMappingDSL.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalMappingDSL.g:93:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalMappingDSL.g:94:3: ( rule__AbstractElement__Alternatives )
            // InternalMappingDSL.g:94:4: rule__AbstractElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleIntegrationMechanismDeclaration"
    // InternalMappingDSL.g:103:1: entryRuleIntegrationMechanismDeclaration : ruleIntegrationMechanismDeclaration EOF ;
    public final void entryRuleIntegrationMechanismDeclaration() throws RecognitionException {
        try {
            // InternalMappingDSL.g:104:1: ( ruleIntegrationMechanismDeclaration EOF )
            // InternalMappingDSL.g:105:1: ruleIntegrationMechanismDeclaration EOF
            {
             before(grammarAccess.getIntegrationMechanismDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleIntegrationMechanismDeclaration();

            state._fsp--;

             after(grammarAccess.getIntegrationMechanismDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegrationMechanismDeclaration"


    // $ANTLR start "ruleIntegrationMechanismDeclaration"
    // InternalMappingDSL.g:112:1: ruleIntegrationMechanismDeclaration : ( ( rule__IntegrationMechanismDeclaration__UnorderedGroup ) ) ;
    public final void ruleIntegrationMechanismDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:116:2: ( ( ( rule__IntegrationMechanismDeclaration__UnorderedGroup ) ) )
            // InternalMappingDSL.g:117:2: ( ( rule__IntegrationMechanismDeclaration__UnorderedGroup ) )
            {
            // InternalMappingDSL.g:117:2: ( ( rule__IntegrationMechanismDeclaration__UnorderedGroup ) )
            // InternalMappingDSL.g:118:3: ( rule__IntegrationMechanismDeclaration__UnorderedGroup )
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()); 
            // InternalMappingDSL.g:119:3: ( rule__IntegrationMechanismDeclaration__UnorderedGroup )
            // InternalMappingDSL.g:119:4: rule__IntegrationMechanismDeclaration__UnorderedGroup
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegrationMechanismDeclaration"


    // $ANTLR start "entryRuleCodestructure"
    // InternalMappingDSL.g:128:1: entryRuleCodestructure : ruleCodestructure EOF ;
    public final void entryRuleCodestructure() throws RecognitionException {
        try {
            // InternalMappingDSL.g:129:1: ( ruleCodestructure EOF )
            // InternalMappingDSL.g:130:1: ruleCodestructure EOF
            {
             before(grammarAccess.getCodestructureRule()); 
            pushFollow(FOLLOW_1);
            ruleCodestructure();

            state._fsp--;

             after(grammarAccess.getCodestructureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCodestructure"


    // $ANTLR start "ruleCodestructure"
    // InternalMappingDSL.g:137:1: ruleCodestructure : ( ( rule__Codestructure__Group__0 ) ) ;
    public final void ruleCodestructure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:141:2: ( ( ( rule__Codestructure__Group__0 ) ) )
            // InternalMappingDSL.g:142:2: ( ( rule__Codestructure__Group__0 ) )
            {
            // InternalMappingDSL.g:142:2: ( ( rule__Codestructure__Group__0 ) )
            // InternalMappingDSL.g:143:3: ( rule__Codestructure__Group__0 )
            {
             before(grammarAccess.getCodestructureAccess().getGroup()); 
            // InternalMappingDSL.g:144:3: ( rule__Codestructure__Group__0 )
            // InternalMappingDSL.g:144:4: rule__Codestructure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Codestructure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCodestructureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCodestructure"


    // $ANTLR start "entryRuleModelElement"
    // InternalMappingDSL.g:153:1: entryRuleModelElement : ruleModelElement EOF ;
    public final void entryRuleModelElement() throws RecognitionException {
        try {
            // InternalMappingDSL.g:154:1: ( ruleModelElement EOF )
            // InternalMappingDSL.g:155:1: ruleModelElement EOF
            {
             before(grammarAccess.getModelElementRule()); 
            pushFollow(FOLLOW_1);
            ruleModelElement();

            state._fsp--;

             after(grammarAccess.getModelElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // InternalMappingDSL.g:162:1: ruleModelElement : ( ( rule__ModelElement__Group__0 ) ) ;
    public final void ruleModelElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:166:2: ( ( ( rule__ModelElement__Group__0 ) ) )
            // InternalMappingDSL.g:167:2: ( ( rule__ModelElement__Group__0 ) )
            {
            // InternalMappingDSL.g:167:2: ( ( rule__ModelElement__Group__0 ) )
            // InternalMappingDSL.g:168:3: ( rule__ModelElement__Group__0 )
            {
             before(grammarAccess.getModelElementAccess().getGroup()); 
            // InternalMappingDSL.g:169:3: ( rule__ModelElement__Group__0 )
            // InternalMappingDSL.g:169:4: rule__ModelElement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ModelElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleCondition"
    // InternalMappingDSL.g:178:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalMappingDSL.g:179:1: ( ruleCondition EOF )
            // InternalMappingDSL.g:180:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalMappingDSL.g:187:1: ruleCondition : ( ( rule__Condition__Group__0 ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:191:2: ( ( ( rule__Condition__Group__0 ) ) )
            // InternalMappingDSL.g:192:2: ( ( rule__Condition__Group__0 ) )
            {
            // InternalMappingDSL.g:192:2: ( ( rule__Condition__Group__0 ) )
            // InternalMappingDSL.g:193:3: ( rule__Condition__Group__0 )
            {
             before(grammarAccess.getConditionAccess().getGroup()); 
            // InternalMappingDSL.g:194:3: ( rule__Condition__Group__0 )
            // InternalMappingDSL.g:194:4: rule__Condition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleMapping"
    // InternalMappingDSL.g:203:1: entryRuleMapping : ruleMapping EOF ;
    public final void entryRuleMapping() throws RecognitionException {
        try {
            // InternalMappingDSL.g:204:1: ( ruleMapping EOF )
            // InternalMappingDSL.g:205:1: ruleMapping EOF
            {
             before(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_1);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getMappingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // InternalMappingDSL.g:212:1: ruleMapping : ( ( rule__Mapping__Group__0 ) ) ;
    public final void ruleMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:216:2: ( ( ( rule__Mapping__Group__0 ) ) )
            // InternalMappingDSL.g:217:2: ( ( rule__Mapping__Group__0 ) )
            {
            // InternalMappingDSL.g:217:2: ( ( rule__Mapping__Group__0 ) )
            // InternalMappingDSL.g:218:3: ( rule__Mapping__Group__0 )
            {
             before(grammarAccess.getMappingAccess().getGroup()); 
            // InternalMappingDSL.g:219:3: ( rule__Mapping__Group__0 )
            // InternalMappingDSL.g:219:4: rule__Mapping__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Mapping__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMappingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleMappingInstantiation"
    // InternalMappingDSL.g:228:1: entryRuleMappingInstantiation : ruleMappingInstantiation EOF ;
    public final void entryRuleMappingInstantiation() throws RecognitionException {
        try {
            // InternalMappingDSL.g:229:1: ( ruleMappingInstantiation EOF )
            // InternalMappingDSL.g:230:1: ruleMappingInstantiation EOF
            {
             before(grammarAccess.getMappingInstantiationRule()); 
            pushFollow(FOLLOW_1);
            ruleMappingInstantiation();

            state._fsp--;

             after(grammarAccess.getMappingInstantiationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMappingInstantiation"


    // $ANTLR start "ruleMappingInstantiation"
    // InternalMappingDSL.g:237:1: ruleMappingInstantiation : ( ( rule__MappingInstantiation__Group__0 ) ) ;
    public final void ruleMappingInstantiation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:241:2: ( ( ( rule__MappingInstantiation__Group__0 ) ) )
            // InternalMappingDSL.g:242:2: ( ( rule__MappingInstantiation__Group__0 ) )
            {
            // InternalMappingDSL.g:242:2: ( ( rule__MappingInstantiation__Group__0 ) )
            // InternalMappingDSL.g:243:3: ( rule__MappingInstantiation__Group__0 )
            {
             before(grammarAccess.getMappingInstantiationAccess().getGroup()); 
            // InternalMappingDSL.g:244:3: ( rule__MappingInstantiation__Group__0 )
            // InternalMappingDSL.g:244:4: rule__MappingInstantiation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MappingInstantiation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMappingInstantiationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMappingInstantiation"


    // $ANTLR start "ruleCodeStructureType"
    // InternalMappingDSL.g:253:1: ruleCodeStructureType : ( ( rule__CodeStructureType__Alternatives ) ) ;
    public final void ruleCodeStructureType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:257:1: ( ( ( rule__CodeStructureType__Alternatives ) ) )
            // InternalMappingDSL.g:258:2: ( ( rule__CodeStructureType__Alternatives ) )
            {
            // InternalMappingDSL.g:258:2: ( ( rule__CodeStructureType__Alternatives ) )
            // InternalMappingDSL.g:259:3: ( rule__CodeStructureType__Alternatives )
            {
             before(grammarAccess.getCodeStructureTypeAccess().getAlternatives()); 
            // InternalMappingDSL.g:260:3: ( rule__CodeStructureType__Alternatives )
            // InternalMappingDSL.g:260:4: rule__CodeStructureType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CodeStructureType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCodeStructureTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCodeStructureType"


    // $ANTLR start "ruleModelElementType"
    // InternalMappingDSL.g:269:1: ruleModelElementType : ( ( rule__ModelElementType__Alternatives ) ) ;
    public final void ruleModelElementType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:273:1: ( ( ( rule__ModelElementType__Alternatives ) ) )
            // InternalMappingDSL.g:274:2: ( ( rule__ModelElementType__Alternatives ) )
            {
            // InternalMappingDSL.g:274:2: ( ( rule__ModelElementType__Alternatives ) )
            // InternalMappingDSL.g:275:3: ( rule__ModelElementType__Alternatives )
            {
             before(grammarAccess.getModelElementTypeAccess().getAlternatives()); 
            // InternalMappingDSL.g:276:3: ( rule__ModelElementType__Alternatives )
            // InternalMappingDSL.g:276:4: rule__ModelElementType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ModelElementType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelElementTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModelElementType"


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // InternalMappingDSL.g:284:1: rule__AbstractElement__Alternatives : ( ( ruleIntegrationMechanismDeclaration ) | ( ruleMappingInstantiation ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:288:1: ( ( ruleIntegrationMechanismDeclaration ) | ( ruleMappingInstantiation ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13||(LA2_0>=18 && LA2_0<=20)) ) {
                alt2=1;
            }
            else if ( (LA2_0==21) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMappingDSL.g:289:2: ( ruleIntegrationMechanismDeclaration )
                    {
                    // InternalMappingDSL.g:289:2: ( ruleIntegrationMechanismDeclaration )
                    // InternalMappingDSL.g:290:3: ruleIntegrationMechanismDeclaration
                    {
                     before(grammarAccess.getAbstractElementAccess().getIntegrationMechanismDeclarationParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntegrationMechanismDeclaration();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getIntegrationMechanismDeclarationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDSL.g:295:2: ( ruleMappingInstantiation )
                    {
                    // InternalMappingDSL.g:295:2: ( ruleMappingInstantiation )
                    // InternalMappingDSL.g:296:3: ruleMappingInstantiation
                    {
                     before(grammarAccess.getAbstractElementAccess().getMappingInstantiationParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMappingInstantiation();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getMappingInstantiationParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__CodeStructureType__Alternatives"
    // InternalMappingDSL.g:305:1: rule__CodeStructureType__Alternatives : ( ( ( 'class' ) ) | ( ( 'method' ) ) );
    public final void rule__CodeStructureType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:309:1: ( ( ( 'class' ) ) | ( ( 'method' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMappingDSL.g:310:2: ( ( 'class' ) )
                    {
                    // InternalMappingDSL.g:310:2: ( ( 'class' ) )
                    // InternalMappingDSL.g:311:3: ( 'class' )
                    {
                     before(grammarAccess.getCodeStructureTypeAccess().getCLASSEnumLiteralDeclaration_0()); 
                    // InternalMappingDSL.g:312:3: ( 'class' )
                    // InternalMappingDSL.g:312:4: 'class'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getCodeStructureTypeAccess().getCLASSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDSL.g:316:2: ( ( 'method' ) )
                    {
                    // InternalMappingDSL.g:316:2: ( ( 'method' ) )
                    // InternalMappingDSL.g:317:3: ( 'method' )
                    {
                     before(grammarAccess.getCodeStructureTypeAccess().getMETHODEnumLiteralDeclaration_1()); 
                    // InternalMappingDSL.g:318:3: ( 'method' )
                    // InternalMappingDSL.g:318:4: 'method'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getCodeStructureTypeAccess().getMETHODEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CodeStructureType__Alternatives"


    // $ANTLR start "rule__ModelElementType__Alternatives"
    // InternalMappingDSL.g:326:1: rule__ModelElementType__Alternatives : ( ( ( 'class' ) ) | ( ( 'method' ) ) );
    public final void rule__ModelElementType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:330:1: ( ( ( 'class' ) ) | ( ( 'method' ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMappingDSL.g:331:2: ( ( 'class' ) )
                    {
                    // InternalMappingDSL.g:331:2: ( ( 'class' ) )
                    // InternalMappingDSL.g:332:3: ( 'class' )
                    {
                     before(grammarAccess.getModelElementTypeAccess().getCLASSEnumLiteralDeclaration_0()); 
                    // InternalMappingDSL.g:333:3: ( 'class' )
                    // InternalMappingDSL.g:333:4: 'class'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getModelElementTypeAccess().getCLASSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDSL.g:337:2: ( ( 'method' ) )
                    {
                    // InternalMappingDSL.g:337:2: ( ( 'method' ) )
                    // InternalMappingDSL.g:338:3: ( 'method' )
                    {
                     before(grammarAccess.getModelElementTypeAccess().getMETHODEnumLiteralDeclaration_1()); 
                    // InternalMappingDSL.g:339:3: ( 'method' )
                    // InternalMappingDSL.g:339:4: 'method'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getModelElementTypeAccess().getMETHODEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElementType__Alternatives"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__0"
    // InternalMappingDSL.g:347:1: rule__IntegrationMechanismDeclaration__Group_0__0 : rule__IntegrationMechanismDeclaration__Group_0__0__Impl rule__IntegrationMechanismDeclaration__Group_0__1 ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:351:1: ( rule__IntegrationMechanismDeclaration__Group_0__0__Impl rule__IntegrationMechanismDeclaration__Group_0__1 )
            // InternalMappingDSL.g:352:2: rule__IntegrationMechanismDeclaration__Group_0__0__Impl rule__IntegrationMechanismDeclaration__Group_0__1
            {
            pushFollow(FOLLOW_4);
            rule__IntegrationMechanismDeclaration__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__0"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__0__Impl"
    // InternalMappingDSL.g:359:1: rule__IntegrationMechanismDeclaration__Group_0__0__Impl : ( 'IM' ) ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:363:1: ( ( 'IM' ) )
            // InternalMappingDSL.g:364:1: ( 'IM' )
            {
            // InternalMappingDSL.g:364:1: ( 'IM' )
            // InternalMappingDSL.g:365:2: 'IM'
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getIMKeyword_0_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getIMKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__0__Impl"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__1"
    // InternalMappingDSL.g:374:1: rule__IntegrationMechanismDeclaration__Group_0__1 : rule__IntegrationMechanismDeclaration__Group_0__1__Impl rule__IntegrationMechanismDeclaration__Group_0__2 ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:378:1: ( rule__IntegrationMechanismDeclaration__Group_0__1__Impl rule__IntegrationMechanismDeclaration__Group_0__2 )
            // InternalMappingDSL.g:379:2: rule__IntegrationMechanismDeclaration__Group_0__1__Impl rule__IntegrationMechanismDeclaration__Group_0__2
            {
            pushFollow(FOLLOW_5);
            rule__IntegrationMechanismDeclaration__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__1"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__1__Impl"
    // InternalMappingDSL.g:386:1: rule__IntegrationMechanismDeclaration__Group_0__1__Impl : ( ( rule__IntegrationMechanismDeclaration__NameAssignment_0_1 ) ) ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:390:1: ( ( ( rule__IntegrationMechanismDeclaration__NameAssignment_0_1 ) ) )
            // InternalMappingDSL.g:391:1: ( ( rule__IntegrationMechanismDeclaration__NameAssignment_0_1 ) )
            {
            // InternalMappingDSL.g:391:1: ( ( rule__IntegrationMechanismDeclaration__NameAssignment_0_1 ) )
            // InternalMappingDSL.g:392:2: ( rule__IntegrationMechanismDeclaration__NameAssignment_0_1 )
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getNameAssignment_0_1()); 
            // InternalMappingDSL.g:393:2: ( rule__IntegrationMechanismDeclaration__NameAssignment_0_1 )
            // InternalMappingDSL.g:393:3: rule__IntegrationMechanismDeclaration__NameAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__1__Impl"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__2"
    // InternalMappingDSL.g:401:1: rule__IntegrationMechanismDeclaration__Group_0__2 : rule__IntegrationMechanismDeclaration__Group_0__2__Impl rule__IntegrationMechanismDeclaration__Group_0__3 ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:405:1: ( rule__IntegrationMechanismDeclaration__Group_0__2__Impl rule__IntegrationMechanismDeclaration__Group_0__3 )
            // InternalMappingDSL.g:406:2: rule__IntegrationMechanismDeclaration__Group_0__2__Impl rule__IntegrationMechanismDeclaration__Group_0__3
            {
            pushFollow(FOLLOW_6);
            rule__IntegrationMechanismDeclaration__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__2"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__2__Impl"
    // InternalMappingDSL.g:413:1: rule__IntegrationMechanismDeclaration__Group_0__2__Impl : ( '{' ) ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:417:1: ( ( '{' ) )
            // InternalMappingDSL.g:418:1: ( '{' )
            {
            // InternalMappingDSL.g:418:1: ( '{' )
            // InternalMappingDSL.g:419:2: '{'
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getLeftCurlyBracketKeyword_0_2()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getLeftCurlyBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__2__Impl"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__3"
    // InternalMappingDSL.g:428:1: rule__IntegrationMechanismDeclaration__Group_0__3 : rule__IntegrationMechanismDeclaration__Group_0__3__Impl ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:432:1: ( rule__IntegrationMechanismDeclaration__Group_0__3__Impl )
            // InternalMappingDSL.g:433:2: rule__IntegrationMechanismDeclaration__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__3"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_0__3__Impl"
    // InternalMappingDSL.g:439:1: rule__IntegrationMechanismDeclaration__Group_0__3__Impl : ( ( rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3 ) ) ;
    public final void rule__IntegrationMechanismDeclaration__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:443:1: ( ( ( rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3 ) ) )
            // InternalMappingDSL.g:444:1: ( ( rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3 ) )
            {
            // InternalMappingDSL.g:444:1: ( ( rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3 ) )
            // InternalMappingDSL.g:445:2: ( rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3 )
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getCodestructureAssignment_0_3()); 
            // InternalMappingDSL.g:446:2: ( rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3 )
            // InternalMappingDSL.g:446:3: rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getCodestructureAssignment_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_0__3__Impl"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_3__0"
    // InternalMappingDSL.g:455:1: rule__IntegrationMechanismDeclaration__Group_3__0 : rule__IntegrationMechanismDeclaration__Group_3__0__Impl rule__IntegrationMechanismDeclaration__Group_3__1 ;
    public final void rule__IntegrationMechanismDeclaration__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:459:1: ( rule__IntegrationMechanismDeclaration__Group_3__0__Impl rule__IntegrationMechanismDeclaration__Group_3__1 )
            // InternalMappingDSL.g:460:2: rule__IntegrationMechanismDeclaration__Group_3__0__Impl rule__IntegrationMechanismDeclaration__Group_3__1
            {
            pushFollow(FOLLOW_7);
            rule__IntegrationMechanismDeclaration__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_3__0"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_3__0__Impl"
    // InternalMappingDSL.g:467:1: rule__IntegrationMechanismDeclaration__Group_3__0__Impl : ( ( rule__IntegrationMechanismDeclaration__MappingAssignment_3_0 ) ) ;
    public final void rule__IntegrationMechanismDeclaration__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:471:1: ( ( ( rule__IntegrationMechanismDeclaration__MappingAssignment_3_0 ) ) )
            // InternalMappingDSL.g:472:1: ( ( rule__IntegrationMechanismDeclaration__MappingAssignment_3_0 ) )
            {
            // InternalMappingDSL.g:472:1: ( ( rule__IntegrationMechanismDeclaration__MappingAssignment_3_0 ) )
            // InternalMappingDSL.g:473:2: ( rule__IntegrationMechanismDeclaration__MappingAssignment_3_0 )
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getMappingAssignment_3_0()); 
            // InternalMappingDSL.g:474:2: ( rule__IntegrationMechanismDeclaration__MappingAssignment_3_0 )
            // InternalMappingDSL.g:474:3: rule__IntegrationMechanismDeclaration__MappingAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__MappingAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getMappingAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_3__0__Impl"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_3__1"
    // InternalMappingDSL.g:482:1: rule__IntegrationMechanismDeclaration__Group_3__1 : rule__IntegrationMechanismDeclaration__Group_3__1__Impl ;
    public final void rule__IntegrationMechanismDeclaration__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:486:1: ( rule__IntegrationMechanismDeclaration__Group_3__1__Impl )
            // InternalMappingDSL.g:487:2: rule__IntegrationMechanismDeclaration__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_3__1"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__Group_3__1__Impl"
    // InternalMappingDSL.g:493:1: rule__IntegrationMechanismDeclaration__Group_3__1__Impl : ( '}' ) ;
    public final void rule__IntegrationMechanismDeclaration__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:497:1: ( ( '}' ) )
            // InternalMappingDSL.g:498:1: ( '}' )
            {
            // InternalMappingDSL.g:498:1: ( '}' )
            // InternalMappingDSL.g:499:2: '}'
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getRightCurlyBracketKeyword_3_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getRightCurlyBracketKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__Group_3__1__Impl"


    // $ANTLR start "rule__Codestructure__Group__0"
    // InternalMappingDSL.g:509:1: rule__Codestructure__Group__0 : rule__Codestructure__Group__0__Impl rule__Codestructure__Group__1 ;
    public final void rule__Codestructure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:513:1: ( rule__Codestructure__Group__0__Impl rule__Codestructure__Group__1 )
            // InternalMappingDSL.g:514:2: rule__Codestructure__Group__0__Impl rule__Codestructure__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Codestructure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codestructure__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codestructure__Group__0"


    // $ANTLR start "rule__Codestructure__Group__0__Impl"
    // InternalMappingDSL.g:521:1: rule__Codestructure__Group__0__Impl : ( 'codestructure' ) ;
    public final void rule__Codestructure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:525:1: ( ( 'codestructure' ) )
            // InternalMappingDSL.g:526:1: ( 'codestructure' )
            {
            // InternalMappingDSL.g:526:1: ( 'codestructure' )
            // InternalMappingDSL.g:527:2: 'codestructure'
            {
             before(grammarAccess.getCodestructureAccess().getCodestructureKeyword_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getCodestructureAccess().getCodestructureKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codestructure__Group__0__Impl"


    // $ANTLR start "rule__Codestructure__Group__1"
    // InternalMappingDSL.g:536:1: rule__Codestructure__Group__1 : rule__Codestructure__Group__1__Impl rule__Codestructure__Group__2 ;
    public final void rule__Codestructure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:540:1: ( rule__Codestructure__Group__1__Impl rule__Codestructure__Group__2 )
            // InternalMappingDSL.g:541:2: rule__Codestructure__Group__1__Impl rule__Codestructure__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__Codestructure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Codestructure__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codestructure__Group__1"


    // $ANTLR start "rule__Codestructure__Group__1__Impl"
    // InternalMappingDSL.g:548:1: rule__Codestructure__Group__1__Impl : ( ':' ) ;
    public final void rule__Codestructure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:552:1: ( ( ':' ) )
            // InternalMappingDSL.g:553:1: ( ':' )
            {
            // InternalMappingDSL.g:553:1: ( ':' )
            // InternalMappingDSL.g:554:2: ':'
            {
             before(grammarAccess.getCodestructureAccess().getColonKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getCodestructureAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codestructure__Group__1__Impl"


    // $ANTLR start "rule__Codestructure__Group__2"
    // InternalMappingDSL.g:563:1: rule__Codestructure__Group__2 : rule__Codestructure__Group__2__Impl ;
    public final void rule__Codestructure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:567:1: ( rule__Codestructure__Group__2__Impl )
            // InternalMappingDSL.g:568:2: rule__Codestructure__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Codestructure__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codestructure__Group__2"


    // $ANTLR start "rule__Codestructure__Group__2__Impl"
    // InternalMappingDSL.g:574:1: rule__Codestructure__Group__2__Impl : ( ( rule__Codestructure__CodestructureAssignment_2 ) ) ;
    public final void rule__Codestructure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:578:1: ( ( ( rule__Codestructure__CodestructureAssignment_2 ) ) )
            // InternalMappingDSL.g:579:1: ( ( rule__Codestructure__CodestructureAssignment_2 ) )
            {
            // InternalMappingDSL.g:579:1: ( ( rule__Codestructure__CodestructureAssignment_2 ) )
            // InternalMappingDSL.g:580:2: ( rule__Codestructure__CodestructureAssignment_2 )
            {
             before(grammarAccess.getCodestructureAccess().getCodestructureAssignment_2()); 
            // InternalMappingDSL.g:581:2: ( rule__Codestructure__CodestructureAssignment_2 )
            // InternalMappingDSL.g:581:3: rule__Codestructure__CodestructureAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Codestructure__CodestructureAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCodestructureAccess().getCodestructureAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codestructure__Group__2__Impl"


    // $ANTLR start "rule__ModelElement__Group__0"
    // InternalMappingDSL.g:590:1: rule__ModelElement__Group__0 : rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 ;
    public final void rule__ModelElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:594:1: ( rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1 )
            // InternalMappingDSL.g:595:2: rule__ModelElement__Group__0__Impl rule__ModelElement__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ModelElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__Group__0"


    // $ANTLR start "rule__ModelElement__Group__0__Impl"
    // InternalMappingDSL.g:602:1: rule__ModelElement__Group__0__Impl : ( 'modelelement' ) ;
    public final void rule__ModelElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:606:1: ( ( 'modelelement' ) )
            // InternalMappingDSL.g:607:1: ( 'modelelement' )
            {
            // InternalMappingDSL.g:607:1: ( 'modelelement' )
            // InternalMappingDSL.g:608:2: 'modelelement'
            {
             before(grammarAccess.getModelElementAccess().getModelelementKeyword_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getModelelementKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__Group__0__Impl"


    // $ANTLR start "rule__ModelElement__Group__1"
    // InternalMappingDSL.g:617:1: rule__ModelElement__Group__1 : rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 ;
    public final void rule__ModelElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:621:1: ( rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2 )
            // InternalMappingDSL.g:622:2: rule__ModelElement__Group__1__Impl rule__ModelElement__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__ModelElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModelElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__Group__1"


    // $ANTLR start "rule__ModelElement__Group__1__Impl"
    // InternalMappingDSL.g:629:1: rule__ModelElement__Group__1__Impl : ( ':' ) ;
    public final void rule__ModelElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:633:1: ( ( ':' ) )
            // InternalMappingDSL.g:634:1: ( ':' )
            {
            // InternalMappingDSL.g:634:1: ( ':' )
            // InternalMappingDSL.g:635:2: ':'
            {
             before(grammarAccess.getModelElementAccess().getColonKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getModelElementAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__Group__1__Impl"


    // $ANTLR start "rule__ModelElement__Group__2"
    // InternalMappingDSL.g:644:1: rule__ModelElement__Group__2 : rule__ModelElement__Group__2__Impl ;
    public final void rule__ModelElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:648:1: ( rule__ModelElement__Group__2__Impl )
            // InternalMappingDSL.g:649:2: rule__ModelElement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModelElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__Group__2"


    // $ANTLR start "rule__ModelElement__Group__2__Impl"
    // InternalMappingDSL.g:655:1: rule__ModelElement__Group__2__Impl : ( ( rule__ModelElement__ModelelementAssignment_2 ) ) ;
    public final void rule__ModelElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:659:1: ( ( ( rule__ModelElement__ModelelementAssignment_2 ) ) )
            // InternalMappingDSL.g:660:1: ( ( rule__ModelElement__ModelelementAssignment_2 ) )
            {
            // InternalMappingDSL.g:660:1: ( ( rule__ModelElement__ModelelementAssignment_2 ) )
            // InternalMappingDSL.g:661:2: ( rule__ModelElement__ModelelementAssignment_2 )
            {
             before(grammarAccess.getModelElementAccess().getModelelementAssignment_2()); 
            // InternalMappingDSL.g:662:2: ( rule__ModelElement__ModelelementAssignment_2 )
            // InternalMappingDSL.g:662:3: rule__ModelElement__ModelelementAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ModelElement__ModelelementAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelElementAccess().getModelelementAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__Group__2__Impl"


    // $ANTLR start "rule__Condition__Group__0"
    // InternalMappingDSL.g:671:1: rule__Condition__Group__0 : rule__Condition__Group__0__Impl rule__Condition__Group__1 ;
    public final void rule__Condition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:675:1: ( rule__Condition__Group__0__Impl rule__Condition__Group__1 )
            // InternalMappingDSL.g:676:2: rule__Condition__Group__0__Impl rule__Condition__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Condition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0"


    // $ANTLR start "rule__Condition__Group__0__Impl"
    // InternalMappingDSL.g:683:1: rule__Condition__Group__0__Impl : ( 'condition' ) ;
    public final void rule__Condition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:687:1: ( ( 'condition' ) )
            // InternalMappingDSL.g:688:1: ( 'condition' )
            {
            // InternalMappingDSL.g:688:1: ( 'condition' )
            // InternalMappingDSL.g:689:2: 'condition'
            {
             before(grammarAccess.getConditionAccess().getConditionKeyword_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConditionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__0__Impl"


    // $ANTLR start "rule__Condition__Group__1"
    // InternalMappingDSL.g:698:1: rule__Condition__Group__1 : rule__Condition__Group__1__Impl rule__Condition__Group__2 ;
    public final void rule__Condition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:702:1: ( rule__Condition__Group__1__Impl rule__Condition__Group__2 )
            // InternalMappingDSL.g:703:2: rule__Condition__Group__1__Impl rule__Condition__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Condition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Condition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1"


    // $ANTLR start "rule__Condition__Group__1__Impl"
    // InternalMappingDSL.g:710:1: rule__Condition__Group__1__Impl : ( ':' ) ;
    public final void rule__Condition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:714:1: ( ( ':' ) )
            // InternalMappingDSL.g:715:1: ( ':' )
            {
            // InternalMappingDSL.g:715:1: ( ':' )
            // InternalMappingDSL.g:716:2: ':'
            {
             before(grammarAccess.getConditionAccess().getColonKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__1__Impl"


    // $ANTLR start "rule__Condition__Group__2"
    // InternalMappingDSL.g:725:1: rule__Condition__Group__2 : rule__Condition__Group__2__Impl ;
    public final void rule__Condition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:729:1: ( rule__Condition__Group__2__Impl )
            // InternalMappingDSL.g:730:2: rule__Condition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__2"


    // $ANTLR start "rule__Condition__Group__2__Impl"
    // InternalMappingDSL.g:736:1: rule__Condition__Group__2__Impl : ( ( rule__Condition__ConditionAssignment_2 ) ) ;
    public final void rule__Condition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:740:1: ( ( ( rule__Condition__ConditionAssignment_2 ) ) )
            // InternalMappingDSL.g:741:1: ( ( rule__Condition__ConditionAssignment_2 ) )
            {
            // InternalMappingDSL.g:741:1: ( ( rule__Condition__ConditionAssignment_2 ) )
            // InternalMappingDSL.g:742:2: ( rule__Condition__ConditionAssignment_2 )
            {
             before(grammarAccess.getConditionAccess().getConditionAssignment_2()); 
            // InternalMappingDSL.g:743:2: ( rule__Condition__ConditionAssignment_2 )
            // InternalMappingDSL.g:743:3: rule__Condition__ConditionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Condition__ConditionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getConditionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Group__2__Impl"


    // $ANTLR start "rule__Mapping__Group__0"
    // InternalMappingDSL.g:752:1: rule__Mapping__Group__0 : rule__Mapping__Group__0__Impl rule__Mapping__Group__1 ;
    public final void rule__Mapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:756:1: ( rule__Mapping__Group__0__Impl rule__Mapping__Group__1 )
            // InternalMappingDSL.g:757:2: rule__Mapping__Group__0__Impl rule__Mapping__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Mapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mapping__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__0"


    // $ANTLR start "rule__Mapping__Group__0__Impl"
    // InternalMappingDSL.g:764:1: rule__Mapping__Group__0__Impl : ( 'mapping' ) ;
    public final void rule__Mapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:768:1: ( ( 'mapping' ) )
            // InternalMappingDSL.g:769:1: ( 'mapping' )
            {
            // InternalMappingDSL.g:769:1: ( 'mapping' )
            // InternalMappingDSL.g:770:2: 'mapping'
            {
             before(grammarAccess.getMappingAccess().getMappingKeyword_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getMappingAccess().getMappingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__0__Impl"


    // $ANTLR start "rule__Mapping__Group__1"
    // InternalMappingDSL.g:779:1: rule__Mapping__Group__1 : rule__Mapping__Group__1__Impl rule__Mapping__Group__2 ;
    public final void rule__Mapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:783:1: ( rule__Mapping__Group__1__Impl rule__Mapping__Group__2 )
            // InternalMappingDSL.g:784:2: rule__Mapping__Group__1__Impl rule__Mapping__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Mapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Mapping__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__1"


    // $ANTLR start "rule__Mapping__Group__1__Impl"
    // InternalMappingDSL.g:791:1: rule__Mapping__Group__1__Impl : ( ':' ) ;
    public final void rule__Mapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:795:1: ( ( ':' ) )
            // InternalMappingDSL.g:796:1: ( ':' )
            {
            // InternalMappingDSL.g:796:1: ( ':' )
            // InternalMappingDSL.g:797:2: ':'
            {
             before(grammarAccess.getMappingAccess().getColonKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getMappingAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__1__Impl"


    // $ANTLR start "rule__Mapping__Group__2"
    // InternalMappingDSL.g:806:1: rule__Mapping__Group__2 : rule__Mapping__Group__2__Impl ;
    public final void rule__Mapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:810:1: ( rule__Mapping__Group__2__Impl )
            // InternalMappingDSL.g:811:2: rule__Mapping__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Mapping__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__2"


    // $ANTLR start "rule__Mapping__Group__2__Impl"
    // InternalMappingDSL.g:817:1: rule__Mapping__Group__2__Impl : ( ( rule__Mapping__MappingAssignment_2 ) ) ;
    public final void rule__Mapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:821:1: ( ( ( rule__Mapping__MappingAssignment_2 ) ) )
            // InternalMappingDSL.g:822:1: ( ( rule__Mapping__MappingAssignment_2 ) )
            {
            // InternalMappingDSL.g:822:1: ( ( rule__Mapping__MappingAssignment_2 ) )
            // InternalMappingDSL.g:823:2: ( rule__Mapping__MappingAssignment_2 )
            {
             before(grammarAccess.getMappingAccess().getMappingAssignment_2()); 
            // InternalMappingDSL.g:824:2: ( rule__Mapping__MappingAssignment_2 )
            // InternalMappingDSL.g:824:3: rule__Mapping__MappingAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Mapping__MappingAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMappingAccess().getMappingAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__Group__2__Impl"


    // $ANTLR start "rule__MappingInstantiation__Group__0"
    // InternalMappingDSL.g:833:1: rule__MappingInstantiation__Group__0 : rule__MappingInstantiation__Group__0__Impl rule__MappingInstantiation__Group__1 ;
    public final void rule__MappingInstantiation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:837:1: ( rule__MappingInstantiation__Group__0__Impl rule__MappingInstantiation__Group__1 )
            // InternalMappingDSL.g:838:2: rule__MappingInstantiation__Group__0__Impl rule__MappingInstantiation__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MappingInstantiation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MappingInstantiation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingInstantiation__Group__0"


    // $ANTLR start "rule__MappingInstantiation__Group__0__Impl"
    // InternalMappingDSL.g:845:1: rule__MappingInstantiation__Group__0__Impl : ( 'Mapping' ) ;
    public final void rule__MappingInstantiation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:849:1: ( ( 'Mapping' ) )
            // InternalMappingDSL.g:850:1: ( 'Mapping' )
            {
            // InternalMappingDSL.g:850:1: ( 'Mapping' )
            // InternalMappingDSL.g:851:2: 'Mapping'
            {
             before(grammarAccess.getMappingInstantiationAccess().getMappingKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getMappingInstantiationAccess().getMappingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingInstantiation__Group__0__Impl"


    // $ANTLR start "rule__MappingInstantiation__Group__1"
    // InternalMappingDSL.g:860:1: rule__MappingInstantiation__Group__1 : rule__MappingInstantiation__Group__1__Impl rule__MappingInstantiation__Group__2 ;
    public final void rule__MappingInstantiation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:864:1: ( rule__MappingInstantiation__Group__1__Impl rule__MappingInstantiation__Group__2 )
            // InternalMappingDSL.g:865:2: rule__MappingInstantiation__Group__1__Impl rule__MappingInstantiation__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__MappingInstantiation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MappingInstantiation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingInstantiation__Group__1"


    // $ANTLR start "rule__MappingInstantiation__Group__1__Impl"
    // InternalMappingDSL.g:872:1: rule__MappingInstantiation__Group__1__Impl : ( '{' ) ;
    public final void rule__MappingInstantiation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:876:1: ( ( '{' ) )
            // InternalMappingDSL.g:877:1: ( '{' )
            {
            // InternalMappingDSL.g:877:1: ( '{' )
            // InternalMappingDSL.g:878:2: '{'
            {
             before(grammarAccess.getMappingInstantiationAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getMappingInstantiationAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingInstantiation__Group__1__Impl"


    // $ANTLR start "rule__MappingInstantiation__Group__2"
    // InternalMappingDSL.g:887:1: rule__MappingInstantiation__Group__2 : rule__MappingInstantiation__Group__2__Impl ;
    public final void rule__MappingInstantiation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:891:1: ( rule__MappingInstantiation__Group__2__Impl )
            // InternalMappingDSL.g:892:2: rule__MappingInstantiation__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MappingInstantiation__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingInstantiation__Group__2"


    // $ANTLR start "rule__MappingInstantiation__Group__2__Impl"
    // InternalMappingDSL.g:898:1: rule__MappingInstantiation__Group__2__Impl : ( '}' ) ;
    public final void rule__MappingInstantiation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:902:1: ( ( '}' ) )
            // InternalMappingDSL.g:903:1: ( '}' )
            {
            // InternalMappingDSL.g:903:1: ( '}' )
            // InternalMappingDSL.g:904:2: '}'
            {
             before(grammarAccess.getMappingInstantiationAccess().getRightCurlyBracketKeyword_2()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getMappingInstantiationAccess().getRightCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingInstantiation__Group__2__Impl"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__UnorderedGroup"
    // InternalMappingDSL.g:914:1: rule__IntegrationMechanismDeclaration__UnorderedGroup : rule__IntegrationMechanismDeclaration__UnorderedGroup__0 {...}?;
    public final void rule__IntegrationMechanismDeclaration__UnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
        	
        try {
            // InternalMappingDSL.g:919:1: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__0 {...}?)
            // InternalMappingDSL.g:920:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__IntegrationMechanismDeclaration__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__UnorderedGroup"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl"
    // InternalMappingDSL.g:928:1: rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) ) ) ) ;
    public final void rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalMappingDSL.g:933:1: ( ( ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) ) ) ) )
            // InternalMappingDSL.g:934:3: ( ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) ) ) )
            {
            // InternalMappingDSL.g:934:3: ( ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) ) ) | ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) ) ) )
            int alt5=4;
            int LA5_0 = input.LA(1);

            if ( LA5_0 == 13 && getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {
                alt5=2;
            }
            else if ( LA5_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2) ) {
                alt5=3;
            }
            else if ( LA5_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3) ) {
                alt5=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMappingDSL.g:935:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) ) )
                    {
                    // InternalMappingDSL.g:935:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) ) )
                    // InternalMappingDSL.g:936:4: {...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0)");
                    }
                    // InternalMappingDSL.g:936:125: ( ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) ) )
                    // InternalMappingDSL.g:937:5: ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0);
                    				

                    					selected = true;
                    				
                    // InternalMappingDSL.g:943:5: ( ( rule__IntegrationMechanismDeclaration__Group_0__0 ) )
                    // InternalMappingDSL.g:944:6: ( rule__IntegrationMechanismDeclaration__Group_0__0 )
                    {
                     before(grammarAccess.getIntegrationMechanismDeclarationAccess().getGroup_0()); 
                    // InternalMappingDSL.g:945:6: ( rule__IntegrationMechanismDeclaration__Group_0__0 )
                    // InternalMappingDSL.g:945:7: rule__IntegrationMechanismDeclaration__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegrationMechanismDeclaration__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntegrationMechanismDeclarationAccess().getGroup_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDSL.g:950:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) ) )
                    {
                    // InternalMappingDSL.g:950:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) ) )
                    // InternalMappingDSL.g:951:4: {...}? => ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1)");
                    }
                    // InternalMappingDSL.g:951:125: ( ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) ) )
                    // InternalMappingDSL.g:952:5: ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1);
                    				

                    					selected = true;
                    				
                    // InternalMappingDSL.g:958:5: ( ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 ) )
                    // InternalMappingDSL.g:959:6: ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 )
                    {
                     before(grammarAccess.getIntegrationMechanismDeclarationAccess().getModelelementAssignment_1()); 
                    // InternalMappingDSL.g:960:6: ( rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 )
                    // InternalMappingDSL.g:960:7: rule__IntegrationMechanismDeclaration__ModelelementAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegrationMechanismDeclaration__ModelelementAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntegrationMechanismDeclarationAccess().getModelelementAssignment_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMappingDSL.g:965:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) ) )
                    {
                    // InternalMappingDSL.g:965:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) ) )
                    // InternalMappingDSL.g:966:4: {...}? => ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2) ) {
                        throw new FailedPredicateException(input, "rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2)");
                    }
                    // InternalMappingDSL.g:966:125: ( ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) ) )
                    // InternalMappingDSL.g:967:5: ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2);
                    				

                    					selected = true;
                    				
                    // InternalMappingDSL.g:973:5: ( ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 ) )
                    // InternalMappingDSL.g:974:6: ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 )
                    {
                     before(grammarAccess.getIntegrationMechanismDeclarationAccess().getConditionAssignment_2()); 
                    // InternalMappingDSL.g:975:6: ( rule__IntegrationMechanismDeclaration__ConditionAssignment_2 )
                    // InternalMappingDSL.g:975:7: rule__IntegrationMechanismDeclaration__ConditionAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegrationMechanismDeclaration__ConditionAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntegrationMechanismDeclarationAccess().getConditionAssignment_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMappingDSL.g:980:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) ) )
                    {
                    // InternalMappingDSL.g:980:3: ({...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) ) )
                    // InternalMappingDSL.g:981:4: {...}? => ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3) ) {
                        throw new FailedPredicateException(input, "rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3)");
                    }
                    // InternalMappingDSL.g:981:125: ( ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) ) )
                    // InternalMappingDSL.g:982:5: ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3);
                    				

                    					selected = true;
                    				
                    // InternalMappingDSL.g:988:5: ( ( rule__IntegrationMechanismDeclaration__Group_3__0 ) )
                    // InternalMappingDSL.g:989:6: ( rule__IntegrationMechanismDeclaration__Group_3__0 )
                    {
                     before(grammarAccess.getIntegrationMechanismDeclarationAccess().getGroup_3()); 
                    // InternalMappingDSL.g:990:6: ( rule__IntegrationMechanismDeclaration__Group_3__0 )
                    // InternalMappingDSL.g:990:7: rule__IntegrationMechanismDeclaration__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegrationMechanismDeclaration__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntegrationMechanismDeclarationAccess().getGroup_3()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__UnorderedGroup__0"
    // InternalMappingDSL.g:1003:1: rule__IntegrationMechanismDeclaration__UnorderedGroup__0 : rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__1 )? ;
    public final void rule__IntegrationMechanismDeclaration__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1007:1: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__1 )? )
            // InternalMappingDSL.g:1008:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_11);
            rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMappingDSL.g:1009:2: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__1 )?
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalMappingDSL.g:1009:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegrationMechanismDeclaration__UnorderedGroup__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__UnorderedGroup__0"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__UnorderedGroup__1"
    // InternalMappingDSL.g:1015:1: rule__IntegrationMechanismDeclaration__UnorderedGroup__1 : rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__2 )? ;
    public final void rule__IntegrationMechanismDeclaration__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1019:1: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__2 )? )
            // InternalMappingDSL.g:1020:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__2 )?
            {
            pushFollow(FOLLOW_11);
            rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMappingDSL.g:1021:2: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__2 )?
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalMappingDSL.g:1021:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegrationMechanismDeclaration__UnorderedGroup__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__UnorderedGroup__1"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__UnorderedGroup__2"
    // InternalMappingDSL.g:1027:1: rule__IntegrationMechanismDeclaration__UnorderedGroup__2 : rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__3 )? ;
    public final void rule__IntegrationMechanismDeclaration__UnorderedGroup__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1031:1: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__3 )? )
            // InternalMappingDSL.g:1032:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ( rule__IntegrationMechanismDeclaration__UnorderedGroup__3 )?
            {
            pushFollow(FOLLOW_11);
            rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl();

            state._fsp--;

            // InternalMappingDSL.g:1033:2: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__3 )?
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalMappingDSL.g:1033:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntegrationMechanismDeclaration__UnorderedGroup__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__UnorderedGroup__2"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__UnorderedGroup__3"
    // InternalMappingDSL.g:1039:1: rule__IntegrationMechanismDeclaration__UnorderedGroup__3 : rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl ;
    public final void rule__IntegrationMechanismDeclaration__UnorderedGroup__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1043:1: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl )
            // InternalMappingDSL.g:1044:2: rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntegrationMechanismDeclaration__UnorderedGroup__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__UnorderedGroup__3"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalMappingDSL.g:1051:1: rule__Model__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1055:1: ( ( ruleAbstractElement ) )
            // InternalMappingDSL.g:1056:2: ( ruleAbstractElement )
            {
            // InternalMappingDSL.g:1056:2: ( ruleAbstractElement )
            // InternalMappingDSL.g:1057:3: ruleAbstractElement
            {
             before(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__NameAssignment_0_1"
    // InternalMappingDSL.g:1066:1: rule__IntegrationMechanismDeclaration__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__IntegrationMechanismDeclaration__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1070:1: ( ( RULE_ID ) )
            // InternalMappingDSL.g:1071:2: ( RULE_ID )
            {
            // InternalMappingDSL.g:1071:2: ( RULE_ID )
            // InternalMappingDSL.g:1072:3: RULE_ID
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__NameAssignment_0_1"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3"
    // InternalMappingDSL.g:1081:1: rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3 : ( ruleCodestructure ) ;
    public final void rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1085:1: ( ( ruleCodestructure ) )
            // InternalMappingDSL.g:1086:2: ( ruleCodestructure )
            {
            // InternalMappingDSL.g:1086:2: ( ruleCodestructure )
            // InternalMappingDSL.g:1087:3: ruleCodestructure
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getCodestructureCodestructureParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCodestructure();

            state._fsp--;

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getCodestructureCodestructureParserRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__CodestructureAssignment_0_3"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__ModelelementAssignment_1"
    // InternalMappingDSL.g:1096:1: rule__IntegrationMechanismDeclaration__ModelelementAssignment_1 : ( ruleModelElement ) ;
    public final void rule__IntegrationMechanismDeclaration__ModelelementAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1100:1: ( ( ruleModelElement ) )
            // InternalMappingDSL.g:1101:2: ( ruleModelElement )
            {
            // InternalMappingDSL.g:1101:2: ( ruleModelElement )
            // InternalMappingDSL.g:1102:3: ruleModelElement
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getModelelementModelElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModelElement();

            state._fsp--;

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getModelelementModelElementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__ModelelementAssignment_1"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__ConditionAssignment_2"
    // InternalMappingDSL.g:1111:1: rule__IntegrationMechanismDeclaration__ConditionAssignment_2 : ( ruleCondition ) ;
    public final void rule__IntegrationMechanismDeclaration__ConditionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1115:1: ( ( ruleCondition ) )
            // InternalMappingDSL.g:1116:2: ( ruleCondition )
            {
            // InternalMappingDSL.g:1116:2: ( ruleCondition )
            // InternalMappingDSL.g:1117:3: ruleCondition
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getConditionConditionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getConditionConditionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__ConditionAssignment_2"


    // $ANTLR start "rule__IntegrationMechanismDeclaration__MappingAssignment_3_0"
    // InternalMappingDSL.g:1126:1: rule__IntegrationMechanismDeclaration__MappingAssignment_3_0 : ( ruleMapping ) ;
    public final void rule__IntegrationMechanismDeclaration__MappingAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1130:1: ( ( ruleMapping ) )
            // InternalMappingDSL.g:1131:2: ( ruleMapping )
            {
            // InternalMappingDSL.g:1131:2: ( ruleMapping )
            // InternalMappingDSL.g:1132:3: ruleMapping
            {
             before(grammarAccess.getIntegrationMechanismDeclarationAccess().getMappingMappingParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMapping();

            state._fsp--;

             after(grammarAccess.getIntegrationMechanismDeclarationAccess().getMappingMappingParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegrationMechanismDeclaration__MappingAssignment_3_0"


    // $ANTLR start "rule__Codestructure__CodestructureAssignment_2"
    // InternalMappingDSL.g:1141:1: rule__Codestructure__CodestructureAssignment_2 : ( ruleCodeStructureType ) ;
    public final void rule__Codestructure__CodestructureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1145:1: ( ( ruleCodeStructureType ) )
            // InternalMappingDSL.g:1146:2: ( ruleCodeStructureType )
            {
            // InternalMappingDSL.g:1146:2: ( ruleCodeStructureType )
            // InternalMappingDSL.g:1147:3: ruleCodeStructureType
            {
             before(grammarAccess.getCodestructureAccess().getCodestructureCodeStructureTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCodeStructureType();

            state._fsp--;

             after(grammarAccess.getCodestructureAccess().getCodestructureCodeStructureTypeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Codestructure__CodestructureAssignment_2"


    // $ANTLR start "rule__ModelElement__ModelelementAssignment_2"
    // InternalMappingDSL.g:1156:1: rule__ModelElement__ModelelementAssignment_2 : ( ruleModelElementType ) ;
    public final void rule__ModelElement__ModelelementAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1160:1: ( ( ruleModelElementType ) )
            // InternalMappingDSL.g:1161:2: ( ruleModelElementType )
            {
            // InternalMappingDSL.g:1161:2: ( ruleModelElementType )
            // InternalMappingDSL.g:1162:3: ruleModelElementType
            {
             before(grammarAccess.getModelElementAccess().getModelelementModelElementTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleModelElementType();

            state._fsp--;

             after(grammarAccess.getModelElementAccess().getModelelementModelElementTypeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModelElement__ModelelementAssignment_2"


    // $ANTLR start "rule__Condition__ConditionAssignment_2"
    // InternalMappingDSL.g:1171:1: rule__Condition__ConditionAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Condition__ConditionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1175:1: ( ( RULE_STRING ) )
            // InternalMappingDSL.g:1176:2: ( RULE_STRING )
            {
            // InternalMappingDSL.g:1176:2: ( RULE_STRING )
            // InternalMappingDSL.g:1177:3: RULE_STRING
            {
             before(grammarAccess.getConditionAccess().getConditionSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getConditionAccess().getConditionSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__ConditionAssignment_2"


    // $ANTLR start "rule__Mapping__MappingAssignment_2"
    // InternalMappingDSL.g:1186:1: rule__Mapping__MappingAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Mapping__MappingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMappingDSL.g:1190:1: ( ( RULE_STRING ) )
            // InternalMappingDSL.g:1191:2: ( RULE_STRING )
            {
            // InternalMappingDSL.g:1191:2: ( RULE_STRING )
            // InternalMappingDSL.g:1192:3: RULE_STRING
            {
             before(grammarAccess.getMappingAccess().getMappingSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMappingAccess().getMappingSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__MappingAssignment_2"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String dfa_1s = "\25\uffff";
    static final String dfa_2s = "\1\5\24\uffff";
    static final String dfa_3s = "\1\15\1\4\3\21\1\uffff\1\16\1\13\2\5\1\20\3\0\1\17\1\21\1\uffff\1\0\1\13\2\0";
    static final String dfa_4s = "\1\25\1\4\3\21\1\uffff\1\16\1\14\2\5\1\20\3\0\1\17\1\21\1\uffff\1\0\1\14\2\0";
    static final String dfa_5s = "\5\uffff\1\2\12\uffff\1\1\4\uffff";
    static final String dfa_6s = "\13\uffff\1\1\1\2\1\3\3\uffff\1\0\1\uffff\1\4\1\5}>";
    static final String[] dfa_7s = {
            "\1\1\4\uffff\1\2\1\3\1\4\1\5",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "",
            "\1\12",
            "\1\13\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\21",
            "\1\22",
            "",
            "\1\uffff",
            "\1\23\1\24",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1009:2: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_17 = input.LA(1);

                         
                        int index6_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index6_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_11 = input.LA(1);

                         
                        int index6_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index6_11);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_12 = input.LA(1);

                         
                        int index6_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index6_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_13 = input.LA(1);

                         
                        int index6_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index6_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_19 = input.LA(1);

                         
                        int index6_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index6_19);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_20 = input.LA(1);

                         
                        int index6_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index6_20);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\13\uffff\1\1\1\2\1\5\3\uffff\1\0\1\uffff\1\3\1\4}>";
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_8;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1021:2: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__2 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_17 = input.LA(1);

                         
                        int index7_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index7_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_11 = input.LA(1);

                         
                        int index7_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index7_11);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_12 = input.LA(1);

                         
                        int index7_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index7_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_19 = input.LA(1);

                         
                        int index7_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index7_19);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_20 = input.LA(1);

                         
                        int index7_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index7_20);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_13 = input.LA(1);

                         
                        int index7_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index7_13);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1033:2: ( rule__IntegrationMechanismDeclaration__UnorderedGroup__3 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_17 = input.LA(1);

                         
                        int index8_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index8_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_11 = input.LA(1);

                         
                        int index8_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index8_11);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_12 = input.LA(1);

                         
                        int index8_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index8_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_13 = input.LA(1);

                         
                        int index8_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index8_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_19 = input.LA(1);

                         
                        int index8_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index8_19);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA8_20 = input.LA(1);

                         
                        int index8_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 5;}

                         
                        input.seek(index8_20);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000003C2002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000001C2002L});

}

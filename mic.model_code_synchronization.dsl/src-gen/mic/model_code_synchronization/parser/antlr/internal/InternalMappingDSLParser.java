package mic.model_code_synchronization.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import mic.model_code_synchronization.services.MappingDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMappingDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'IM'", "'{'", "'}'", "'codestructure'", "':'", "'modelelement'", "'condition'", "'mapping'", "'Mapping'", "'class'", "'method'"
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

        public InternalMappingDSLParser(TokenStream input, MappingDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MappingDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMappingDSL.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMappingDSL.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalMappingDSL.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMappingDSL.g:72:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalMappingDSL.g:78:2: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // InternalMappingDSL.g:79:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // InternalMappingDSL.g:79:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||(LA1_0>=16 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMappingDSL.g:80:3: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // InternalMappingDSL.g:80:3: (lv_elements_0_0= ruleAbstractElement )
            	    // InternalMappingDSL.g:81:4: lv_elements_0_0= ruleAbstractElement
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"mic.model_code_synchronization.MappingDSL.AbstractElement");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalMappingDSL.g:101:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // InternalMappingDSL.g:101:56: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // InternalMappingDSL.g:102:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalMappingDSL.g:108:1: ruleAbstractElement returns [EObject current=null] : (this_IntegrationMechanismDeclaration_0= ruleIntegrationMechanismDeclaration | ruleMappingInstantiation ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_IntegrationMechanismDeclaration_0 = null;



        	enterRule();

        try {
            // InternalMappingDSL.g:114:2: ( (this_IntegrationMechanismDeclaration_0= ruleIntegrationMechanismDeclaration | ruleMappingInstantiation ) )
            // InternalMappingDSL.g:115:2: (this_IntegrationMechanismDeclaration_0= ruleIntegrationMechanismDeclaration | ruleMappingInstantiation )
            {
            // InternalMappingDSL.g:115:2: (this_IntegrationMechanismDeclaration_0= ruleIntegrationMechanismDeclaration | ruleMappingInstantiation )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11||(LA2_0>=16 && LA2_0<=18)) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMappingDSL.g:116:3: this_IntegrationMechanismDeclaration_0= ruleIntegrationMechanismDeclaration
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getIntegrationMechanismDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegrationMechanismDeclaration_0=ruleIntegrationMechanismDeclaration();

                    state._fsp--;


                    			current = this_IntegrationMechanismDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMappingDSL.g:125:3: ruleMappingInstantiation
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getMappingInstantiationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    ruleMappingInstantiation();

                    state._fsp--;


                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleIntegrationMechanismDeclaration"
    // InternalMappingDSL.g:136:1: entryRuleIntegrationMechanismDeclaration returns [EObject current=null] : iv_ruleIntegrationMechanismDeclaration= ruleIntegrationMechanismDeclaration EOF ;
    public final EObject entryRuleIntegrationMechanismDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegrationMechanismDeclaration = null;


        try {
            // InternalMappingDSL.g:136:72: (iv_ruleIntegrationMechanismDeclaration= ruleIntegrationMechanismDeclaration EOF )
            // InternalMappingDSL.g:137:2: iv_ruleIntegrationMechanismDeclaration= ruleIntegrationMechanismDeclaration EOF
            {
             newCompositeNode(grammarAccess.getIntegrationMechanismDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegrationMechanismDeclaration=ruleIntegrationMechanismDeclaration();

            state._fsp--;

             current =iv_ruleIntegrationMechanismDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegrationMechanismDeclaration"


    // $ANTLR start "ruleIntegrationMechanismDeclaration"
    // InternalMappingDSL.g:143:1: ruleIntegrationMechanismDeclaration returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleIntegrationMechanismDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_codestructure_4_0 = null;

        EObject lv_modelelement_5_0 = null;

        EObject lv_condition_6_0 = null;

        EObject lv_mapping_7_0 = null;



        	enterRule();

        try {
            // InternalMappingDSL.g:149:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalMappingDSL.g:150:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalMappingDSL.g:150:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?) ) )
            // InternalMappingDSL.g:151:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalMappingDSL.g:151:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?) )
            // InternalMappingDSL.g:152:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            			
            // InternalMappingDSL.g:155:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?)
            // InternalMappingDSL.g:156:5: ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+ {...}?
            {
            // InternalMappingDSL.g:156:5: ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=5;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // InternalMappingDSL.g:157:3: ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) )
            	    {
            	    // InternalMappingDSL.g:157:3: ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) )
            	    // InternalMappingDSL.g:158:4: {...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalMappingDSL.g:158:125: ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) )
            	    // InternalMappingDSL.g:159:5: ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalMappingDSL.g:162:8: ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) )
            	    // InternalMappingDSL.g:162:9: {...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "true");
            	    }
            	    // InternalMappingDSL.g:162:18: (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) )
            	    // InternalMappingDSL.g:162:19: otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) )
            	    {
            	    otherlv_1=(Token)match(input,11,FOLLOW_4); 

            	    								newLeafNode(otherlv_1, grammarAccess.getIntegrationMechanismDeclarationAccess().getIMKeyword_0_0());
            	    							
            	    // InternalMappingDSL.g:166:8: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalMappingDSL.g:167:9: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalMappingDSL.g:167:9: (lv_name_2_0= RULE_ID )
            	    // InternalMappingDSL.g:168:10: lv_name_2_0= RULE_ID
            	    {
            	    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            	    										newLeafNode(lv_name_2_0, grammarAccess.getIntegrationMechanismDeclarationAccess().getNameIDTerminalRuleCall_0_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getIntegrationMechanismDeclarationRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_6); 

            	    								newLeafNode(otherlv_3, grammarAccess.getIntegrationMechanismDeclarationAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalMappingDSL.g:188:8: ( (lv_codestructure_4_0= ruleCodestructure ) )
            	    // InternalMappingDSL.g:189:9: (lv_codestructure_4_0= ruleCodestructure )
            	    {
            	    // InternalMappingDSL.g:189:9: (lv_codestructure_4_0= ruleCodestructure )
            	    // InternalMappingDSL.g:190:10: lv_codestructure_4_0= ruleCodestructure
            	    {

            	    										newCompositeNode(grammarAccess.getIntegrationMechanismDeclarationAccess().getCodestructureCodestructureParserRuleCall_0_3_0());
            	    									
            	    pushFollow(FOLLOW_7);
            	    lv_codestructure_4_0=ruleCodestructure();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getIntegrationMechanismDeclarationRule());
            	    										}
            	    										set(
            	    											current,
            	    											"codestructure",
            	    											lv_codestructure_4_0,
            	    											"mic.model_code_synchronization.MappingDSL.Codestructure");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalMappingDSL.g:213:3: ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) )
            	    {
            	    // InternalMappingDSL.g:213:3: ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) )
            	    // InternalMappingDSL.g:214:4: {...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalMappingDSL.g:214:125: ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) )
            	    // InternalMappingDSL.g:215:5: ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalMappingDSL.g:218:8: ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) )
            	    // InternalMappingDSL.g:218:9: {...}? => ( (lv_modelelement_5_0= ruleModelElement ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "true");
            	    }
            	    // InternalMappingDSL.g:218:18: ( (lv_modelelement_5_0= ruleModelElement ) )
            	    // InternalMappingDSL.g:218:19: (lv_modelelement_5_0= ruleModelElement )
            	    {
            	    // InternalMappingDSL.g:218:19: (lv_modelelement_5_0= ruleModelElement )
            	    // InternalMappingDSL.g:219:9: lv_modelelement_5_0= ruleModelElement
            	    {

            	    									newCompositeNode(grammarAccess.getIntegrationMechanismDeclarationAccess().getModelelementModelElementParserRuleCall_1_0());
            	    								
            	    pushFollow(FOLLOW_7);
            	    lv_modelelement_5_0=ruleModelElement();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getIntegrationMechanismDeclarationRule());
            	    									}
            	    									set(
            	    										current,
            	    										"modelelement",
            	    										lv_modelelement_5_0,
            	    										"mic.model_code_synchronization.MappingDSL.ModelElement");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalMappingDSL.g:241:3: ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) )
            	    {
            	    // InternalMappingDSL.g:241:3: ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) )
            	    // InternalMappingDSL.g:242:4: {...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalMappingDSL.g:242:125: ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) )
            	    // InternalMappingDSL.g:243:5: ({...}? => ( (lv_condition_6_0= ruleCondition ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalMappingDSL.g:246:8: ({...}? => ( (lv_condition_6_0= ruleCondition ) ) )
            	    // InternalMappingDSL.g:246:9: {...}? => ( (lv_condition_6_0= ruleCondition ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "true");
            	    }
            	    // InternalMappingDSL.g:246:18: ( (lv_condition_6_0= ruleCondition ) )
            	    // InternalMappingDSL.g:246:19: (lv_condition_6_0= ruleCondition )
            	    {
            	    // InternalMappingDSL.g:246:19: (lv_condition_6_0= ruleCondition )
            	    // InternalMappingDSL.g:247:9: lv_condition_6_0= ruleCondition
            	    {

            	    									newCompositeNode(grammarAccess.getIntegrationMechanismDeclarationAccess().getConditionConditionParserRuleCall_2_0());
            	    								
            	    pushFollow(FOLLOW_7);
            	    lv_condition_6_0=ruleCondition();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getIntegrationMechanismDeclarationRule());
            	    									}
            	    									set(
            	    										current,
            	    										"condition",
            	    										lv_condition_6_0,
            	    										"mic.model_code_synchronization.MappingDSL.Condition");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalMappingDSL.g:269:3: ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) )
            	    {
            	    // InternalMappingDSL.g:269:3: ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) )
            	    // InternalMappingDSL.g:270:4: {...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalMappingDSL.g:270:125: ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) )
            	    // InternalMappingDSL.g:271:5: ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalMappingDSL.g:274:8: ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) )
            	    // InternalMappingDSL.g:274:9: {...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "true");
            	    }
            	    // InternalMappingDSL.g:274:18: ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' )
            	    // InternalMappingDSL.g:274:19: ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}'
            	    {
            	    // InternalMappingDSL.g:274:19: ( (lv_mapping_7_0= ruleMapping ) )
            	    // InternalMappingDSL.g:275:9: (lv_mapping_7_0= ruleMapping )
            	    {
            	    // InternalMappingDSL.g:275:9: (lv_mapping_7_0= ruleMapping )
            	    // InternalMappingDSL.g:276:10: lv_mapping_7_0= ruleMapping
            	    {

            	    										newCompositeNode(grammarAccess.getIntegrationMechanismDeclarationAccess().getMappingMappingParserRuleCall_3_0_0());
            	    									
            	    pushFollow(FOLLOW_8);
            	    lv_mapping_7_0=ruleMapping();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getIntegrationMechanismDeclarationRule());
            	    										}
            	    										set(
            	    											current,
            	    											"mapping",
            	    											lv_mapping_7_0,
            	    											"mic.model_code_synchronization.MappingDSL.Mapping");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_8=(Token)match(input,13,FOLLOW_7); 

            	    								newLeafNode(otherlv_8, grammarAccess.getIntegrationMechanismDeclarationAccess().getRightCurlyBracketKeyword_3_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleIntegrationMechanismDeclaration", "getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegrationMechanismDeclaration"


    // $ANTLR start "entryRuleCodestructure"
    // InternalMappingDSL.g:314:1: entryRuleCodestructure returns [EObject current=null] : iv_ruleCodestructure= ruleCodestructure EOF ;
    public final EObject entryRuleCodestructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodestructure = null;


        try {
            // InternalMappingDSL.g:314:54: (iv_ruleCodestructure= ruleCodestructure EOF )
            // InternalMappingDSL.g:315:2: iv_ruleCodestructure= ruleCodestructure EOF
            {
             newCompositeNode(grammarAccess.getCodestructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCodestructure=ruleCodestructure();

            state._fsp--;

             current =iv_ruleCodestructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCodestructure"


    // $ANTLR start "ruleCodestructure"
    // InternalMappingDSL.g:321:1: ruleCodestructure returns [EObject current=null] : (otherlv_0= 'codestructure' otherlv_1= ':' ( (lv_codestructure_2_0= ruleCodeStructureType ) ) ) ;
    public final EObject ruleCodestructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_codestructure_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDSL.g:327:2: ( (otherlv_0= 'codestructure' otherlv_1= ':' ( (lv_codestructure_2_0= ruleCodeStructureType ) ) ) )
            // InternalMappingDSL.g:328:2: (otherlv_0= 'codestructure' otherlv_1= ':' ( (lv_codestructure_2_0= ruleCodeStructureType ) ) )
            {
            // InternalMappingDSL.g:328:2: (otherlv_0= 'codestructure' otherlv_1= ':' ( (lv_codestructure_2_0= ruleCodeStructureType ) ) )
            // InternalMappingDSL.g:329:3: otherlv_0= 'codestructure' otherlv_1= ':' ( (lv_codestructure_2_0= ruleCodeStructureType ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getCodestructureAccess().getCodestructureKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getCodestructureAccess().getColonKeyword_1());
            		
            // InternalMappingDSL.g:337:3: ( (lv_codestructure_2_0= ruleCodeStructureType ) )
            // InternalMappingDSL.g:338:4: (lv_codestructure_2_0= ruleCodeStructureType )
            {
            // InternalMappingDSL.g:338:4: (lv_codestructure_2_0= ruleCodeStructureType )
            // InternalMappingDSL.g:339:5: lv_codestructure_2_0= ruleCodeStructureType
            {

            					newCompositeNode(grammarAccess.getCodestructureAccess().getCodestructureCodeStructureTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_codestructure_2_0=ruleCodeStructureType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCodestructureRule());
            					}
            					set(
            						current,
            						"codestructure",
            						lv_codestructure_2_0,
            						"mic.model_code_synchronization.MappingDSL.CodeStructureType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCodestructure"


    // $ANTLR start "entryRuleModelElement"
    // InternalMappingDSL.g:360:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // InternalMappingDSL.g:360:53: (iv_ruleModelElement= ruleModelElement EOF )
            // InternalMappingDSL.g:361:2: iv_ruleModelElement= ruleModelElement EOF
            {
             newCompositeNode(grammarAccess.getModelElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelElement=ruleModelElement();

            state._fsp--;

             current =iv_ruleModelElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // InternalMappingDSL.g:367:1: ruleModelElement returns [EObject current=null] : (otherlv_0= 'modelelement' otherlv_1= ':' ( (lv_modelelement_2_0= ruleModelElementType ) ) ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_modelelement_2_0 = null;



        	enterRule();

        try {
            // InternalMappingDSL.g:373:2: ( (otherlv_0= 'modelelement' otherlv_1= ':' ( (lv_modelelement_2_0= ruleModelElementType ) ) ) )
            // InternalMappingDSL.g:374:2: (otherlv_0= 'modelelement' otherlv_1= ':' ( (lv_modelelement_2_0= ruleModelElementType ) ) )
            {
            // InternalMappingDSL.g:374:2: (otherlv_0= 'modelelement' otherlv_1= ':' ( (lv_modelelement_2_0= ruleModelElementType ) ) )
            // InternalMappingDSL.g:375:3: otherlv_0= 'modelelement' otherlv_1= ':' ( (lv_modelelement_2_0= ruleModelElementType ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getModelElementAccess().getModelelementKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getModelElementAccess().getColonKeyword_1());
            		
            // InternalMappingDSL.g:383:3: ( (lv_modelelement_2_0= ruleModelElementType ) )
            // InternalMappingDSL.g:384:4: (lv_modelelement_2_0= ruleModelElementType )
            {
            // InternalMappingDSL.g:384:4: (lv_modelelement_2_0= ruleModelElementType )
            // InternalMappingDSL.g:385:5: lv_modelelement_2_0= ruleModelElementType
            {

            					newCompositeNode(grammarAccess.getModelElementAccess().getModelelementModelElementTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_modelelement_2_0=ruleModelElementType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelElementRule());
            					}
            					set(
            						current,
            						"modelelement",
            						lv_modelelement_2_0,
            						"mic.model_code_synchronization.MappingDSL.ModelElementType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleCondition"
    // InternalMappingDSL.g:406:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalMappingDSL.g:406:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalMappingDSL.g:407:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalMappingDSL.g:413:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'condition' otherlv_1= ':' ( (lv_condition_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_condition_2_0=null;


        	enterRule();

        try {
            // InternalMappingDSL.g:419:2: ( (otherlv_0= 'condition' otherlv_1= ':' ( (lv_condition_2_0= RULE_STRING ) ) ) )
            // InternalMappingDSL.g:420:2: (otherlv_0= 'condition' otherlv_1= ':' ( (lv_condition_2_0= RULE_STRING ) ) )
            {
            // InternalMappingDSL.g:420:2: (otherlv_0= 'condition' otherlv_1= ':' ( (lv_condition_2_0= RULE_STRING ) ) )
            // InternalMappingDSL.g:421:3: otherlv_0= 'condition' otherlv_1= ':' ( (lv_condition_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getColonKeyword_1());
            		
            // InternalMappingDSL.g:429:3: ( (lv_condition_2_0= RULE_STRING ) )
            // InternalMappingDSL.g:430:4: (lv_condition_2_0= RULE_STRING )
            {
            // InternalMappingDSL.g:430:4: (lv_condition_2_0= RULE_STRING )
            // InternalMappingDSL.g:431:5: lv_condition_2_0= RULE_STRING
            {
            lv_condition_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_condition_2_0, grammarAccess.getConditionAccess().getConditionSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"condition",
            						lv_condition_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleMapping"
    // InternalMappingDSL.g:451:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapping = null;


        try {
            // InternalMappingDSL.g:451:48: (iv_ruleMapping= ruleMapping EOF )
            // InternalMappingDSL.g:452:2: iv_ruleMapping= ruleMapping EOF
            {
             newCompositeNode(grammarAccess.getMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapping=ruleMapping();

            state._fsp--;

             current =iv_ruleMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // InternalMappingDSL.g:458:1: ruleMapping returns [EObject current=null] : (otherlv_0= 'mapping' otherlv_1= ':' ( (lv_mapping_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_mapping_2_0=null;


        	enterRule();

        try {
            // InternalMappingDSL.g:464:2: ( (otherlv_0= 'mapping' otherlv_1= ':' ( (lv_mapping_2_0= RULE_STRING ) ) ) )
            // InternalMappingDSL.g:465:2: (otherlv_0= 'mapping' otherlv_1= ':' ( (lv_mapping_2_0= RULE_STRING ) ) )
            {
            // InternalMappingDSL.g:465:2: (otherlv_0= 'mapping' otherlv_1= ':' ( (lv_mapping_2_0= RULE_STRING ) ) )
            // InternalMappingDSL.g:466:3: otherlv_0= 'mapping' otherlv_1= ':' ( (lv_mapping_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingAccess().getMappingKeyword_0());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getMappingAccess().getColonKeyword_1());
            		
            // InternalMappingDSL.g:474:3: ( (lv_mapping_2_0= RULE_STRING ) )
            // InternalMappingDSL.g:475:4: (lv_mapping_2_0= RULE_STRING )
            {
            // InternalMappingDSL.g:475:4: (lv_mapping_2_0= RULE_STRING )
            // InternalMappingDSL.g:476:5: lv_mapping_2_0= RULE_STRING
            {
            lv_mapping_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_mapping_2_0, grammarAccess.getMappingAccess().getMappingSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMappingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"mapping",
            						lv_mapping_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleMappingInstantiation"
    // InternalMappingDSL.g:496:1: entryRuleMappingInstantiation returns [String current=null] : iv_ruleMappingInstantiation= ruleMappingInstantiation EOF ;
    public final String entryRuleMappingInstantiation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMappingInstantiation = null;


        try {
            // InternalMappingDSL.g:496:60: (iv_ruleMappingInstantiation= ruleMappingInstantiation EOF )
            // InternalMappingDSL.g:497:2: iv_ruleMappingInstantiation= ruleMappingInstantiation EOF
            {
             newCompositeNode(grammarAccess.getMappingInstantiationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingInstantiation=ruleMappingInstantiation();

            state._fsp--;

             current =iv_ruleMappingInstantiation.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingInstantiation"


    // $ANTLR start "ruleMappingInstantiation"
    // InternalMappingDSL.g:503:1: ruleMappingInstantiation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Mapping' kw= '{' kw= '}' ) ;
    public final AntlrDatatypeRuleToken ruleMappingInstantiation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMappingDSL.g:509:2: ( (kw= 'Mapping' kw= '{' kw= '}' ) )
            // InternalMappingDSL.g:510:2: (kw= 'Mapping' kw= '{' kw= '}' )
            {
            // InternalMappingDSL.g:510:2: (kw= 'Mapping' kw= '{' kw= '}' )
            // InternalMappingDSL.g:511:3: kw= 'Mapping' kw= '{' kw= '}'
            {
            kw=(Token)match(input,19,FOLLOW_5); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getMappingInstantiationAccess().getMappingKeyword_0());
            		
            kw=(Token)match(input,12,FOLLOW_8); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getMappingInstantiationAccess().getLeftCurlyBracketKeyword_1());
            		
            kw=(Token)match(input,13,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getMappingInstantiationAccess().getRightCurlyBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingInstantiation"


    // $ANTLR start "ruleCodeStructureType"
    // InternalMappingDSL.g:530:1: ruleCodeStructureType returns [Enumerator current=null] : ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) ) ;
    public final Enumerator ruleCodeStructureType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDSL.g:536:2: ( ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) ) )
            // InternalMappingDSL.g:537:2: ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) )
            {
            // InternalMappingDSL.g:537:2: ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            else if ( (LA4_0==21) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMappingDSL.g:538:3: (enumLiteral_0= 'class' )
                    {
                    // InternalMappingDSL.g:538:3: (enumLiteral_0= 'class' )
                    // InternalMappingDSL.g:539:4: enumLiteral_0= 'class'
                    {
                    enumLiteral_0=(Token)match(input,20,FOLLOW_2); 

                    				current = grammarAccess.getCodeStructureTypeAccess().getCLASSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCodeStructureTypeAccess().getCLASSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDSL.g:546:3: (enumLiteral_1= 'method' )
                    {
                    // InternalMappingDSL.g:546:3: (enumLiteral_1= 'method' )
                    // InternalMappingDSL.g:547:4: enumLiteral_1= 'method'
                    {
                    enumLiteral_1=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getCodeStructureTypeAccess().getMETHODEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCodeStructureTypeAccess().getMETHODEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCodeStructureType"


    // $ANTLR start "ruleModelElementType"
    // InternalMappingDSL.g:557:1: ruleModelElementType returns [Enumerator current=null] : ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) ) ;
    public final Enumerator ruleModelElementType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMappingDSL.g:563:2: ( ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) ) )
            // InternalMappingDSL.g:564:2: ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) )
            {
            // InternalMappingDSL.g:564:2: ( (enumLiteral_0= 'class' ) | (enumLiteral_1= 'method' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            else if ( (LA5_0==21) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMappingDSL.g:565:3: (enumLiteral_0= 'class' )
                    {
                    // InternalMappingDSL.g:565:3: (enumLiteral_0= 'class' )
                    // InternalMappingDSL.g:566:4: enumLiteral_0= 'class'
                    {
                    enumLiteral_0=(Token)match(input,20,FOLLOW_2); 

                    				current = grammarAccess.getModelElementTypeAccess().getCLASSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getModelElementTypeAccess().getCLASSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMappingDSL.g:573:3: (enumLiteral_1= 'method' )
                    {
                    // InternalMappingDSL.g:573:3: (enumLiteral_1= 'method' )
                    // InternalMappingDSL.g:574:4: enumLiteral_1= 'method'
                    {
                    enumLiteral_1=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getModelElementTypeAccess().getMETHODEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getModelElementTypeAccess().getMETHODEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelElementType"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\1\11\uffff";
    static final String dfa_3s = "\1\13\1\uffff\4\0\4\uffff";
    static final String dfa_4s = "\1\23\1\uffff\4\0\4\uffff";
    static final String dfa_5s = "\1\uffff\1\5\4\uffff\1\1\1\2\1\3\1\4";
    static final String dfa_6s = "\2\uffff\1\2\1\3\1\0\1\1\4\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\4\uffff\1\3\1\4\1\5\1\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 156:5: ( ({...}? => ( ({...}? => (otherlv_1= 'IM' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_codestructure_4_0= ruleCodestructure ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_modelelement_5_0= ruleModelElement ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_condition_6_0= ruleCondition ) ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_mapping_7_0= ruleMapping ) ) otherlv_8= '}' ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_4 = input.LA(1);

                         
                        int index3_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 2) ) {s = 8;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index3_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 3) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_2 = input.LA(1);

                         
                        int index3_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 0) ) {s = 6;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index3_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_3 = input.LA(1);

                         
                        int index3_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup(), 1) ) {s = 7;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getIntegrationMechanismDeclarationAccess().getUnorderedGroup()) ) {s = 1;}

                         
                        input.seek(index3_3);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000000F0802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000070802L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});

}

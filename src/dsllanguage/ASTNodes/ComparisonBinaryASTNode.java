/* BSD 3-Clause License
 *
 * Copyright (c) 2017, Louis Jenkins <LouisJenkinsCS@hotmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *
 *     - Neither the name of Louis Jenkins, Bloomsburg University nor the names of its 
 *       contributors may be used to endorse or promote products derived
 *       from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package dsllanguage.ASTNodes;

import dsllanguage.DSLLexer;

/**
 *
 * @author Louis Jenkins
 */
public class ComparisonBinaryASTNode extends BinaryASTNode {
    String type;

    public ComparisonBinaryASTNode(ASTNode left, ASTNode right, String type) {
        super(left, right);
        this.type = type;
    }
    
    @Override
    protected Object op(Object left, Object right) {
        if (left == null || right == null) {
            DSLLexer.yyerror("One of Equality Operands are null...");
        }
        
        if (type.equals("==")) {
            return left.equals(right);
        } else if (type.equals("!=")) {
            return !left.equals(right);
        } else {
            if (!(left instanceof Integer) && !(right instanceof Integer)) {
                DSLLexer.yyerror("Comparison of wrong types...");
            }
            
            Integer leftInt = (Integer) left;
            Integer rightInt = (Integer) right;
            
            if (type.equals("<")) {
                return leftInt < rightInt;
            } else if (type.equals(">")) {
                return leftInt < rightInt;
            } else if (type.equals("<=")) {
                return leftInt <= rightInt;
            } else if (type.equals(">=")) {
                return leftInt >= rightInt;
            } else {
                DSLLexer.yyerror("Operator not supported: " + type);
            }
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        return type;
    }
    
}

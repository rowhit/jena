/*
 * (c) Copyright 2007, 2008 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.sparql.modify.op;

import com.hp.hpl.jena.graph.Node;


public abstract class GraphMgt extends Update
{
    private Node iri = null ;         // Null means default graph.  Which is illegal for management ops.
    boolean silent = false ; 
    
    protected GraphMgt(Node iri, boolean silent) { this.iri = iri ; this.silent = silent ; }

    protected void setIRI(Node iri) { this.iri = iri ; }
//    protected void setURI(String uri) { this.iri = uri ; }
    
    public Node getIRI() { return iri ; }  
    public Node getURI() { return iri ; }
    
    protected void setSilent(boolean silent)
    { this.silent = silent ; }

    public boolean isSilent()
    { return silent ; }
    
//    abstract
//    public void exec(GraphStore graphStore, Node iri) ;
//    
//    //@Override 
//    final public void exec(GraphStore graphStore, Binding binding)
//    {
//        // Ignore binding.
//        exec(graphStore, iri) ;
//    }
//    
//    //@Override 
//    final public void exec(GraphStore graphStore)
//    {
//        exec(graphStore, iri) ;
//    }
}

/*
 * (c) Copyright 2007, 2008 Hewlett-Packard Development Company, LP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
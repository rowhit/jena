/*
 * (c) Copyright 2006, 2007 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.sdb;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.impl.ModelCom;
import com.hp.hpl.jena.sdb.graph.GraphSDB;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import com.hp.hpl.jena.sdb.store.Store;


public class ModelSDB extends ModelCom implements Model
{

//    public ModelSDB(String jdbcURL, Schema schema, String user, String password)
//    {
//        this(new SDBConnection(jdbcURL, user, password), schema) ;
//    }
//    
    public ModelSDB(Store store)
    {
        super(new GraphSDB(store)) ;
    }
    
    public ModelSDB(GraphSDB graph)
    {
        super(graph) ;
    }
        
    public SDBConnection getConnection() { return getGraphSDB().getStore().getConnection() ; }
    
    public void reformat()
    {
        Store s = getGraphSDB().getStore() ;
        s.getTableFormatter().format()  ; 
    }

    // Beware of prefixes
    /* This short circuits removeAll, which breaks the listener contract
     * (removed triples won't be seen). Probably minor, however.
     * Wrap in bulk update due to MySQL locking idiocy. Sigh.
     */
    @Override
    public Model removeAll()
    { 
        Store s = getGraphSDB().getStore() ;
        getGraphSDB().startBulkUpdate();
        s.getTableFormatter().truncate() ;
        getGraphSDB().finishBulkUpdate();
        return this ;
    }
    
    public GraphSDB getGraphSDB() { return (GraphSDB)getGraph() ; }
}

/*
 * (c) Copyright 2006, 2007 Hewlett-Packard Development Company, LP
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
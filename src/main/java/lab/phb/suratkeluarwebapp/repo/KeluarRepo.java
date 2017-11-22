/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.phb.suratkeluarwebapp.repo;

import lab.phb.suratkeluarwebapp.entity.Keluar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fina
 */
@Repository
public interface KeluarRepo 
        extends JpaRepository<Keluar,String> {
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service;

public interface RebotChangeProvider {

    public void addRebotChangeListener(RebotChangeListener pl);

    public void removeTimeChangeListener(RebotChangeListener pl);
}

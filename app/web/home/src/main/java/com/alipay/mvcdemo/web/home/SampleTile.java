/**
 * Alipay.com Inc.
 * Copyright (c) 2005-2010 All Rights Reserved.
 */
package com.alipay.mvcdemo.web.home;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.sofa.web.mvc.core.annotation.Tile;

/**
 * A simple tile.
 */
@Tile
@RequestMapping("sampleTile.vm")
public class SampleTile {
	/**
	 * @return
	 */
	@RequestMapping
	public void render() {
	}
}

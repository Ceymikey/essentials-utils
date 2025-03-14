/*
 * This file is part of McTiersBridge, https://github.com/Ceymikey/McTiersBridge
 *
 * Copyright (c) 2024-2025 Ceymikeydev and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.ceymikey.mcTiersBridge.util;

import dev.ceymikey.mcTiersBridge.McTiersBridgeAPI;

/**
 * This class is used for various methods to
 * get the players MCTIER from the official backend.
 */
public class TierBridge extends McTiersBridgeAPI {
    /**
     * Gets the players MCTIER from the official backend
     * @param player  the player to get the rank from
     * @param type    the type of rank data to get
     * @return        returns the players tier
     */
    public Object getData(String player, Types type) {
        Https request = new Https.builder()
                .setEndpoint("https://mctiers.com/api/search_profile/" + player)
                .setType(type)
                .build();
        Object tier;
        try {
            tier = request.returnTier();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tier;
    }
}

package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("mao", "soul").set("geek","lk");
        String geek = fullRequest.headers().get("geek");
        if (geek == null){
            ctx.close();

        }
    }
}

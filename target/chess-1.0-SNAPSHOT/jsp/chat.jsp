<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fn" %>

<%@include file="../lib(header&footer)/mainHead.jsp" %>
<div style="width: 100%; margin-bottom: -3%">
    <h5 style="color: white; text-align: center">${mess1}</h5>
    <div id='turn'>It's Whites Turn!</div>
</div>

<div class="box d-flex justify-content-around p-5">
    <div class="chess mx-auto">
        <div id="game"
             style="border-radius: 15px !important; background: rgba(98, 30, 66, 0.63) !important; box-shadow: 0 15px 25px #eedef9e1;">
            <div class='gamecell purple' id='1_8'></div>
            <div class='gamecell grey' id='2_8'></div>
            <div class='gamecell purple' id='3_8'></div>
            <div class='gamecell grey' id='4_8'></div>
            <div class='gamecell purple' id='5_8'></div>
            <div class='gamecell grey' id='6_8'></div>
            <div class='gamecell purple' id='7_8'></div>
            <div class='gamecell grey' id='8_8'></div>
            <div class='gamecell grey' id='1_7'></div>
            <div class='gamecell purple' id='2_7'></div>
            <div class='gamecell grey' id='3_7'></div>
            <div class='gamecell purple' id='4_7'></div>
            <div class='gamecell grey' id='5_7'></div>
            <div class='gamecell purple' id='6_7'></div>
            <div class='gamecell grey' id='7_7'></div>
            <div class='gamecell purple' id='8_7'></div>
            <div class='gamecell purple' id='1_6'></div>
            <div class='gamecell grey' id='2_6'></div>
            <div class='gamecell purple' id='3_6'></div>
            <div class='gamecell grey' id='4_6'></div>
            <div class='gamecell purple' id='5_6'></div>
            <div class='gamecell grey' id='6_6'></div>
            <div class='gamecell purple' id='7_6'></div>
            <div class='gamecell grey' id='8_6'></div>
            <div class='gamecell grey' id='1_5'></div>
            <div class='gamecell purple' id='2_5'></div>
            <div class='gamecell grey' id='3_5'></div>
            <div class='gamecell purple' id='4_5'></div>
            <div class='gamecell grey' id='5_5'></div>
            <div class='gamecell purple' id='6_5'></div>
            <div class='gamecell grey' id='7_5'></div>
            <div class='gamecell purple' id='8_5'></div>
            <div class='gamecell purple' id='1_4'></div>
            <div class='gamecell grey' id='2_4'></div>
            <div class='gamecell purple' id='3_4'></div>
            <div class='gamecell grey' id='4_4'></div>
            <div class='gamecell purple' id='5_4'></div>
            <div class='gamecell grey' id='6_4'></div>
            <div class='gamecell purple' id='7_4'></div>
            <div class='gamecell grey' id='8_4'></div>
            <div class='gamecell grey' id='1_3'></div>
            <div class='gamecell purple' id='2_3'></div>
            <div class='gamecell grey' id='3_3'></div>
            <div class='gamecell purple' id='4_3'></div>
            <div class='gamecell grey' id='5_3'></div>
            <div class='gamecell purple' id='6_3'></div>
            <div class='gamecell grey' id='7_3'></div>
            <div class='gamecell purple' id='8_3'></div>
            <div class='gamecell purple' id='1_2'></div>
            <div class='gamecell grey' id='2_2'></div>
            <div class='gamecell purple' id='3_2'></div>
            <div class='gamecell grey' id='4_2'></div>
            <div class='gamecell purple' id='5_2'></div>
            <div class='gamecell grey' id='6_2'></div>
            <div class='gamecell purple' id='7_2'></div>
            <div class='gamecell grey' id='8_2'></div>
            <div class='gamecell grey' id='1_1'></div>
            <div class='gamecell purple' id='2_1'></div>
            <div class='gamecell grey' id='3_1'></div>
            <div class='gamecell purple' id='4_1'></div>
            <div class='gamecell grey' id='5_1'></div>
            <div class='gamecell purple' id='6_1'></div>
            <div class='gamecell grey' id='7_1'></div>
            <div class='gamecell purple' id='8_1'></div>
        </div>

    </div>

    <div class="chat ">
        <div class="container-fluid h-100">
            <div class="row justify-content-center h-100">
                <!--col-md-8 col-xl-6-->
                <div class=" chat">
                    <div class="card">
                        <!--chat header-->
                        <div class="card-header msg_head">

                            <div class="d-flex bd-highlight">

                                <div class="img_cont">
                                    <img src="https://i.pinimg.com/originals/1d/f2/e1/1df2e14bf3c45c0cd6582a4a2b9b0bb6.jpg"
                                         class="rounded-circle user_img">
                                </div>

                                <div class="user_info">
                                    <span>Server Player</span>
                                </div>

                            </div>

                        </div>
                        <!--chat dialogue-->
                        <div class="card-body msg_card_body">
                            <c:forEach var="message" items="${messages}">

                                <c:if test="${message.form==pageContext.session.id}">
                                    <div class="d-flex justify-content-end mb-4 ml-5">
                                        <div class="msg_cotainer_send">
                                            <c:if test="${message.file!=null}">some file was uploaded</c:if>

                                                ${message.message}
                                            <span class="msg_time_send">${message.date}</span>
                                        </div>
                                    </div>
                                </c:if>

                                <c:if test="${message.from!=pageContext.session.id}">
                                    <div class="d-flex justify-content-start mb-4 mr-5">
                                        <div class="msg_cotainer">
                                            <c:if test="${message.file!=null}">some file was uploaded</c:if>

                                                ${message.message}
                                            <span class="msg_time"> ${message.date}</span>
                                        </div>
                                    </div>
                                </c:if>

                            </c:forEach>
                            <!--
                                server dialogue
                                <div class="d-flex justify-content-start mb-4 mr-5">
                                    <div class="msg_cotainer">
                                        i love pony
                                        <span class="msg_time">8:40 AM, Today</span>
                                    </div>
                                </div>

                                 ur dialogue
                                <div class="d-flex justify-content-end mb-4 ml-5">
                                    <div class="msg_cotainer_send">
                                        i don't XD :D
                                        <span class="msg_time_send">${time}</span>
                                    </div>
                                </div>
                                -->
                        </div>

                        <!--enter message to chat !CHAT FOOTER-->
                        <div class="card-footer">
                            <form action="${pageContext.request.contextPath}/chat" method="post" class="input-group"
                                  enctype="multipart/form-data">
                                <!--visual file btn-->
                                <div id="fileInput" onclick="btn(this.id)" class="input-group-append">
                                        <span class="input-group-text attach_btn">
                                            <i class="fas fa-paperclip"></i>
                                        </span>
                                </div>

                                <textarea name="textInput" class="form-control type_msg"
                                          placeholder="Type your message..."></textarea>

                                <!--visual submit btn-->
                                <div id="send" onclick="btn(this.id)" class="input-group-append">
                                    <span class="input-group-text send_btn"><i class="fas fa-location-arrow"></i></span>
                                </div>

                                <!--real hidden btn-->
                                <div hidden>
                                    <input type="text" name="from" value="${pageContext.session.id}">
                                    <input type="file" id="fileInputBtn" name="file">
                                    <input type="submit" id="sendBtn">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>

</html>
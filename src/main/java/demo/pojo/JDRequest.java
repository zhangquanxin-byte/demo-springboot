package demo.pojo;

import lombok.Data;

@Data
public class JDRequest {
    private SyncReqHeader header;
    private ReqBodyJDMT001 body;
}
